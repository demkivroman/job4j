package ru.job4j.tracker;

public class AllItems implements UserAction {
    @Override
    public String name() {
        return "=== Show all Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(String.format("%s %s", item.getId(), item.getName()));
        }
        return true;
    }
}
