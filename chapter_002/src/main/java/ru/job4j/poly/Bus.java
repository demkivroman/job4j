package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
         System.out.println("Bus is driving");
    }

    @Override
    public void passangers(int count) {
        drive();
        System.out.println("With " + count + " passangers");
    }

    @Override
    public double fillFuel(double fuel) {
        return 31.25 * fuel;
    }
}
