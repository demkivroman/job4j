package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.TrackerSQL;

import java.util.List;

public class SingleTracker4 {
    private SingleTracker4() {

    }
    public static SingleTracker4 getInstance() {
        return Holder.INSTANCE;
    }
    private static final class Holder {
        private static final SingleTracker4 INSTANCE = new SingleTracker4();
    }

    private Store memTracker = new TrackerSQL();

    public Item add(Item item) {
        return this.memTracker.add(item);
    }
    public boolean replace(String id, Item item) {
        return this.memTracker.replace(id, item);
    }
    public boolean delete(String id) {
        return this.memTracker.delete(id);
    }

    public List<Item> findAll() {
        return this.memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return this.memTracker.findByName(key);
    }

    public Item findById(String id) {
        return this.memTracker.findById(id);
    }
}
