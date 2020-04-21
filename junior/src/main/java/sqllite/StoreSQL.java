package sqllite;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;

    }
    public void generate(int size) {
        String url = "jdbc:sqlite:" + config.get("url");
        try {
            connect = DriverManager.getConnection(url);
            String createTab = "create table if not exists entry (field INTEGER)";
            Statement stmt = connect.createStatement();
            stmt.execute(createTab);
            stmt.executeUpdate("delete from entry");
            PreparedStatement pstm = connect.prepareStatement("insert into entry (field)"
                    + "values (?)");
            for (int i = 1; i <= size; i++) {
                pstm.setInt(1, i);
                pstm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public List<Entry> load() {
        String url = "jdbc:sqlite:" + config.get("url");
        List<Entry> result = new LinkedList<>();
        try {
            connect = DriverManager.getConnection(url);
            String query = "select * from entry";
            Statement st = connect.createStatement();
            ResultSet rsl = st.executeQuery(query);
            while (rsl.next()) {
                result.add(new Entry(rsl.getInt("field")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
    @XmlType(name = "entry")
    @XmlRootElement
    public static class Entry {
        private Integer field;

        public Entry(Integer field) {
            this.field = field;
        }

        public Integer getField() {
            return field;
        }
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.init();
        StoreSQL bd = new StoreSQL(config);
        bd.generate(15);
        bd.load().forEach(System.out::println);
    }
}
