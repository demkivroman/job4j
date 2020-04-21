package sql.tracker;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.util.List;

public class TrackerSQL implements ITracker, AutoCloseable {
    public Item add(Item item) {
        return null;
    }

    public boolean replace(String s, Item item) {
        return false;
    }

    public boolean delete(String s) {
        return false;
    }

    public List<Item> findAll() {
        return null;
    }

    public List<Item> findByName(String s) {
        return null;
    }

    public Item findById(String s) {
        return null;
    }

    public void close() throws Exception {

    }
}
