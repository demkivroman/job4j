package ru.job4j.tracker;

public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public int key() {
        return 0;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    @Override
    public String info() {
        return null;
    }

    public boolean isCall() {
        return call;
    }
}
