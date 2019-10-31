package ru.job4j.oop.profession;

public class Engineer extends Profession {
    public String category;
    public String getCategory() {
        return category;
    }
    public Engineer() {
        super();
    };
    public Engineer(String name) {
        super(name);
    }
}
