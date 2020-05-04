package ru.job4j.tracker;

public class FindById extends BaseAction {
    public FindById(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter id: ");
        Item im = tracker.findById(id);
        if (im != null) {
            System.out.println("Found item: " + im.getName() + " - " + im.getId());
        }
        return true;
    }
}
