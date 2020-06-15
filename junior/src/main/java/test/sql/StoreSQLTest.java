package test.sql;

import test.sql.Config;

import java.sql.*;
import java.util.List;

public class StoreSQLTest implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQLTest(Config config) {
        this.config = config;
        config.init();
        String url = config.get("jdbc.url");
        String username = config.get("jdbc.username");
        String password = config.get("jdbc.password");
        try {
            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        generate();
    }

    public void generate() {

        try {
            Statement stm = connect.createStatement();

            String createTabDepar = "create table if not exists departments (" +
                    "depar_id serial primary key," +
                    "name varchar(100) not null )";
            stm.execute(createTabDepar);

            String createTabEmp = "create table if not exists employer (" +
                    "emp_id serial primary key," +
                    "dep_id integer references departments(depar_id)," +
                    "first_name varchar(100) not null," +
                    "last_name varchar(100) not null )";
            stm.execute(createTabEmp);

            String createTabClient = "create table if not exists client (" +
                    "client_id serial primary key," +
                    "emp_id integer references employer(emp_id)," +
                    "name varchar(100) not null )";
            stm.execute(createTabClient);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillDepartments() {
        List<Department> deps = List.of(
                new Department (1, "IT"),
                new Department (2, "Spoiler"),
                new Department (3, "Food"),
                new Department (4, "Drink"),
                new Department (5, "Car")
        );
        String query = "insert into departments (name) values (?)";
        try {
            PreparedStatement pstm = connect.prepareStatement(query);
            deps.forEach(
                    line -> {
                        try {
                            pstm.setString(1, line.getName());
                            pstm.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillEmployer() {
        List<Employer> emps = List.of(
                new Employer(1, 16, "Roman", "Demkiv"),
                new Employer(2, 16, "Roman", "Krutel"),
                new Employer(3, 16, "Petr", "Hnativ"),
                new Employer(4, 17, "Oksana", "Oksan")
        );
        String query = "insert into employer (dep_id, first_name, last_name)" +
                "values (?,?,?)";

        try {
            PreparedStatement pstm = connect.prepareStatement(query);
            emps.forEach(
                    line -> {
                        try {
                            pstm.setInt(1, line.getDep_id());
                            pstm.setString(2, line.getFirst_name());
                            pstm.setString(3, line.getLast_name());
                            pstm.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void fillClient() {
        List<Client> clients = List.of(
                new Client(1, 1, "Google"),
                new Client(2, 1, "Microsoft"),
                new Client(3, 1, "Macintosh"),
                new Client(4, 2, "Microsystem")
        );

        String query = "insert into client (emp_id, name) values (?,?)";

        try {
            PreparedStatement pstm = connect.prepareStatement(query);
            clients.forEach(
                    line -> {
                        try {
                            pstm.setInt(1, line.getEmp_id());
                            pstm.setString(2, line.getName());
                            pstm.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}
