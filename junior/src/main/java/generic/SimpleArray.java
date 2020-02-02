package generic;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int index;

    public SimpleArray(int size) {
        this.array = new Object[size];
        index = 0;
    }
    public void add(T model) {
        if (index >= this.array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[index++] = model;
    }
    public void set(int index, T model) {
        this.array[index] = model;
    }
    public boolean remove(int index) {
        this.array[index] = null;
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.array[this.array.length - 1] = null;
        this.index--;
        return true;
    }
    public T get(int index) {
        T rsl = (T) this.array[index];
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList((T[]) this.array).iterator();
    }
}