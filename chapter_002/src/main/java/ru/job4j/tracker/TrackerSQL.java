package ru.job4j.tracker;


import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements Store  {
    private Connection cn;

    public TrackerSQL() {
        this.init();
    }

    @Override
    public void init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("jdbc.url"),
                    config.getProperty("jdbc.username"),
                    config.getProperty("jdbc.password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item) {
        String createItems = "create table if not exists items "
                + "(id serial primary key,"
                + "name varchar(100) not null)";

        String sqlAddItem = "insert into items (name) values (?)";

        Statement st = null;
        PreparedStatement sql = null;

        try {
            st = cn.createStatement();
            st.executeUpdate(createItems);
            sql = cn.prepareStatement(sqlAddItem);
            sql.setString(1, item.getName());
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean rsl = false;
        String sql = "update items set name = ? where id = ?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, item.getName());
            st.setInt(2, Integer.valueOf(id));
            st.executeUpdate();
            rsl = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        String sql = "delete from items where id = ?";
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, Integer.valueOf(id));
            st.executeUpdate();
            rsl = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sql = "select * from items";
        try {
            Statement st = cn.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Item item = new Item(res.getString("name"));
                item.setId(String.valueOf(res.getInt("id")));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        String sql = "select * from items where name = ?";
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, key);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Item item = new Item(res.getString("name"));
                item.setId(String.valueOf(res.getInt("id")));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(String id) {
        String sql = "select * from items where id = ?";
        Item rsl = null;
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, Integer.valueOf(id));
            ResultSet res = st.executeQuery();
            if (res.next()) {
                rsl = new Item(res.getString("name"));
                rsl.setId(String.valueOf(res.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

}
