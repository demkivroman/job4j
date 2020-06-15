package test.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RetrieveTest implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public RetrieveTest(Config config) {
        String url = config.get("jdbc.url");
        String username = config.get("jdbc.username");
        String password = config.get("jdbc.password");
        this.config = config;
        config.init();
        try {
            connect = DriverManager.getConnection(url, username, password);
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

    public List<Department> getAllDepartments() {
        List<Department> rsl = new ArrayList<>();
        String query = "Select * from departments";
        try {
            Statement stm = connect.createStatement();
            ResultSet set = stm.executeQuery(query);
            while (set.next()) {
                Department depObj = new Department(
                        set.getInt("depar_id"),
                        set.getString("name")
                );
                rsl.add(depObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public List<Employer> getAllEmployers() {
        List<Employer> rsl = new LinkedList<>();
        String query = "Select * from employer";
        try {
            Statement stm = connect.createStatement();
            ResultSet set = stm.executeQuery(query);
            while (set.next()) {
                Employer emp = new Employer(
                        set.getInt("emp_id"),
                        set.getInt("dep_id"),
                        set.getString("first_name"),
                        set.getString("last_name")
                );
                rsl.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public List<Client> getAllClients() {
        List<Client> clients = new LinkedList<>();
        String query = "Select * from client";
        try {
            Statement stm = connect.createStatement();
            ResultSet set = stm.executeQuery(query);
            while (set.next()) {
                Client emp = new Client(
                        set.getInt("client_id"),
                        set.getInt("emp_id"),
                        set.getString("name")
                );
                clients.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
