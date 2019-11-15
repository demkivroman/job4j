package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item im = tracker.findById(id);
        if (im != null) {
            System.out.println("Found item: " + im.getName() + " - " + im.getId());
        }
        return true;
    }
}
