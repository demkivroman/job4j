package ru.job4j.oop;

public class Battary {
    private int load;
    public Battary(int load) {
        this.load = load;
    }
    public void exchange(Battary another) {
        another.load = another.load + this.load;
        this.load = 0;
    }
    public static void main(String[] args) {
        Battary first = new Battary(75);
        Battary second = new Battary(25);
        System.out.println("first " + first.load + " second " + second.load);
        first.exchange(second);
        System.out.println("first " + first.load + " second " + second.load);
    }
}
