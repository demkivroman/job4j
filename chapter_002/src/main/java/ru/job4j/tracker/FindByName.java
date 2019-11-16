package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        for (Item im : tracker.findByName(name)) {
            System.out.println(String.format("%s - %s", im.getName(), im.getId()));
        }
        return true;
    }
}
