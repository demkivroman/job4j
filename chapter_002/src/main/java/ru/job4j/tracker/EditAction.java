package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Item replaced");
        }
        return true;
    }
}
