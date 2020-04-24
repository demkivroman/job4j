package ru.job4j.tracker;

public interface UserAction {
    int key();
    boolean execute(Input input, ITracker tracker);
    String info();
}
