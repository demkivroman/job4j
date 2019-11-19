package ru.job4j.tracker;

public interface UserAction {
    int key();
    boolean execute(Input input, Tracker tracker);
    String info();
}
