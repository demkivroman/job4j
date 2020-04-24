package ru.job4j.tracker;

public class DeleteAction extends BaseAction {
    public DeleteAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Item id - " + id + " deleted!");
        } else {
            System.out.println("Item is not deleted!");
        }

        return true;
    }
}
