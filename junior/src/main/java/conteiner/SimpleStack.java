package conteiner;

import list.SimpleArrayList;

public class SimpleStack<T> {
    private SimpleArrayList<T> container;
    private int position;

    public SimpleStack() {
        this.container = new SimpleArrayList<>();
        this.position = 0;
    }

    public T poll() {
        T rsl = null;
        if (position < this.container.getSize()) {
            rsl = container.get(position);
            this.position++;
        }
        return rsl;
    }

    public void push(T value) {
        if (value != null) {
            this.container.add(value);
        }
    }
}
