package ru.job4j.tracker;

import java.util.function.Consumer;

public class MenuTracker {
    private final Input input;
    private final ITracker tracker;
    private final Consumer<String> output;

    public MenuTracker(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
}
