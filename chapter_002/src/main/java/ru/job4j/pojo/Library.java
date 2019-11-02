package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("Clean code", 1523);
        Book b2 = new Book("Java", 1003);
        Book b3 = new Book("C#", 987);
        Book b4 = new Book("Python", 1002);
        Book[] library = new Book[4];
        library[0] = b1;
        library[1] = b2;
        library[2] = b3;
        library[3] = b4;
        for (Book index: library) {
            System.out.println(index.getName() + " (pages: " + index.getPages() + ")");
        }
        System.out.println("Replace books index 0 with index 3");
        Book tmp;
        tmp = library[3];
        library[3] = library[0];
        library[0] = tmp;
        for (Book index: library) {
            System.out.println(index.getName() + " (pages: " + index.getPages() + ")");
        }
        System.out.println("Output books with name 'Clean code'");
        for (Book index: library) {
            if (index.getName().equals("Clean code")) {
                System.out.println(index.getName() + " (pages: " + index.getPages() + ")");
            }
        }
    }
}
