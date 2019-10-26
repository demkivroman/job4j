package ru.job4j.oop;

public class BallStrory {
    public static void main(String[] args) {
        Fox fox = new Fox();
        Wolf walf = new Wolf();
        Hare hare = new Hare();
        Ball ball = new Ball();
        fox.tryEat(ball);
        walf.tryEat(ball);
        hare.tryEat(ball);
    }
}
