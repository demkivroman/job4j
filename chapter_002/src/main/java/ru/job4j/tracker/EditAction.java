package ru.job4j.tracker;

public class EditAction extends BaseAction {
    public EditAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Item replaced");
        }
        return true;
    }
}
