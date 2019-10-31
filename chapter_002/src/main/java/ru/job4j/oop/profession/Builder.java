package ru.job4j.oop.profession;

public class Builder extends Engineer {
    public Character gender;
    public String speciality;
    public Builder() {
        super();
    }
    public Builder(String name) {
        super(name);
    }
}
