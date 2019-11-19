package ru.job4j.tracker;

public class AllItems extends BaseAction {
    public AllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(String.format("%s %s", item.getId(), item.getName()));
        }
        return true;
    }
}
