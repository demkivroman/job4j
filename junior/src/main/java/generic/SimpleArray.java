package generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    public boolean set(int index, T model) {
        boolean rsl = false;
        if (index < this.index) {
            this.array[index] = model;
            rsl = true;
        }
        return rsl;
    }
    public boolean remove(int index) {
        boolean rsl = false;
        if (this.array[index] != null) {
            this.array[index] = null;
            System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
            this.array[this.array.length - 1] = null;
            this.index--;
            rsl = true;
        }
        return rsl;
    }
    public T get(int index) {
        T rsl = (T) this.array[index];
        return rsl;
    }
    private class SimpleArrayIter implements Iterator<T> {
        private int step;
        private Object[] iterArray;

        public SimpleArrayIter() {
            this.step = 0;
            iterArray = Arrays.copyOf(array, index);
        }

        @Override
        public boolean hasNext() {
            return iterArray.length > step;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) this.iterArray[step++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIter();
    }
}