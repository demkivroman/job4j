package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select:");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
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
                System.out.println("Enter id: ");
                String id = scanner.nextLine();
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                tracker.replace(id, new Item(name));
            } else if (select == 3) {
                System.out.println("=== Delete Item ===");
                System.out.println("Enter id: ");
                String id = scanner.nextLine();
                tracker.delete(id);
                System.out.println("Item id - " + id + " deleted!");
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.println("Enter id: ");
                String id = scanner.nextLine();
                Item im = tracker.findById(id);
                System.out.println("Found item: " + im.getName() + " - " + im.getId());
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
