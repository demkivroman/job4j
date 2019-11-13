package ru.job4j.tracker;

public class AllItems implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item im : items) {
            System.out.println(im.getName() + " - " + im.getId());
        }
        return true;
    }
}
