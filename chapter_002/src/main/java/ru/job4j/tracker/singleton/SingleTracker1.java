package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

public class SingleTracker1 {
    private static SingleTracker1 instance;
    private Tracker tracker = new Tracker();
    private SingleTracker1() {

    }
    public static SingleTracker1 getInstance() {
        if (instance == null) {
            instance = new SingleTracker1();
        }
        return instance;
    }

    public Item add(Item item) {
        return this.tracker.add(item);
    }
    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }
    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public List<Item> findAll() {
        return this.tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return this.tracker.findByName(key);
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }
}
