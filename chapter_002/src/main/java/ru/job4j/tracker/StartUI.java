package ru.job4j.tracker;


public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select:");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Items ===");
                Item[] items = tracker.findAll();
                for (Item im : items) {
                  System.out.println(im.getName() + " - " + im.getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ===");
                String id = input.askStr("Enter id: ");
                String name = input.askStr("Enter new name: ");
                tracker.replace(id, new Item(name));
            } else if (select == 3) {
                System.out.println("=== Delete Item ===");
                String id = input.askStr("Enter id: ");
                tracker.delete(id);
                System.out.println("Item id - " + id + " deleted!");
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                String id = input.askStr("Enter id: ");
                Item im = tracker.findById(id);
                System.out.println("Found item: " + im.getName() + " - " + im.getId());
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                String name = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(name);
                for (Item im : items) {
                    System.out.println(im.getName() + " - " + im.getId());
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
