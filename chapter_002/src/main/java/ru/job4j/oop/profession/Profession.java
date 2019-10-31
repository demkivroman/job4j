package ru.job4j.oop.profession;

public class Profession {
    public String name;
    public String surname;
    public String education;
    public String birthday;

    public Profession() {
        
    }
    public Profession(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
