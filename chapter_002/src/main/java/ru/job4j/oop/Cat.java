package ru.job4j.oop;

public class Cat {
    private String food;
    private String name;
    public void giveNick(String nick) {
        this.name = nick;
    }
    public void show() {
        System.out.println("Cat " + name + " eat " + food);
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        peppy.giveNick("black");
        peppy.eat("fish");
        peppy.show();
    }
}
