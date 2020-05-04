package ru.job4j.tracker;

public interface UserAction {
    int key();
    boolean execute(Input input, Store tracker);
    String info();
}
