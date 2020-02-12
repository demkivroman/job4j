package conteiner;

import list.SimpleArrayList;

public class SimpleStack<T> {
    private SimpleArrayList<T> container;

    public SimpleStack() {
        this.container = new SimpleArrayList<>();
    }

    public T poll() {
        T rsl = this.container.delete();
        return rsl;
    }

    public void push(T value) {
        if (value != null) {
            this.container.add(value);
        }
    }
}
