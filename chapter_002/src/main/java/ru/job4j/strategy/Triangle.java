package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder square = new StringBuilder();
        square.append("      x     ");
        square.append(System.lineSeparator());
        square.append("    x x x   ");
        square.append(System.lineSeparator());
        square.append("  x x x x x  ");
        square.append(System.lineSeparator());
        square.append("x x x x x x x ");
        return square.toString();
    }
}
