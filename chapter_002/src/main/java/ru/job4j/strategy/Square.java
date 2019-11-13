package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder square = new StringBuilder();
        square.append("x x x x");
        square.append(System.lineSeparator());
        square.append("x x x x");
        square.append(System.lineSeparator());
        square.append("x x x x");
        square.append(System.lineSeparator());
        square.append("x x x x");
        return square.toString();
    }
}
