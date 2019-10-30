package ru.job4j.oop;

public class Tiger extends Predator {
    public Tiger() {
        super();
        System.out.println("load class: Tiger");
    }
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
    }
}
