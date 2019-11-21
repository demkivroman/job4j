package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public enum SingleTracker2 {
    INSTANCE;
    private Tracker tracker = new Tracker();

    public Item add(Item item) {
        return this.tracker.add(item);
    }
    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }
    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }

    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }
}
