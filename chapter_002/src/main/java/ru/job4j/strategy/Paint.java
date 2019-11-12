package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    public static void main(String[] args) {
        Shape shape = new Square();
        Paint paint = new Paint();
        paint.draw(shape);
        shape = new Triangle();
        paint.draw(shape);
    }
}
