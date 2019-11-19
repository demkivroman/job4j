package ru.job4j.tracker;

public class FindByName extends BaseAction {
    public FindByName(int key, String name) {
        super(key, name);
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
