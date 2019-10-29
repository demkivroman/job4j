package ru.job4j.oop;

public class User {
    /**
     * name - class field, because it has private modificator and is located
     * inside class, and is visible for all mathods in those class.
     */
    private String name;
    /**
     * age - class field as well, for same reasons
     */
    private int age;

    public boolean canDrive() {
        /**
         * can - local variable. It's located inside method and is only visible inside those
         * method.
         */
        boolean can = false;
        if (age >= 18) {
            can = true;
        }
        return can;
    }
}
