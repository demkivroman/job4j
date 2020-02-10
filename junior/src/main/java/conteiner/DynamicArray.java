package conteiner;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> implements Iterable<E> {
    private Object[] container;
    private final int contSize = 3;
    private int modCount = 0;
    private int size = 0;
    private int containerSize = contSize;
    private int len = 0;
    public DynamicArray() {
        this.container = new Object[containerSize];
    }
    public DynamicArray(int value) {
        this.containerSize = value;
    }

    public void add(E value) {
        if (len >= containerSize) {
            containerSize += contSize;
            container = Arrays.copyOf(container, containerSize);
            container[size++] = value;
            len = size;
            modCount++;
        } else {
            container[size++] = value;
            modCount++;
            len++;
        }
    }

    public E get(int index) {
        E rsl = null;
        if (index < size) {
            rsl = (E) container[index];
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int step = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return size > step;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[step++];
            }
        };
    }
}
