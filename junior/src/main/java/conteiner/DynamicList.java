package conteiner;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private int modCount;

    public boolean add(E value) {
        boolean rsl = false;
        if (value != null) {
            Node<E> node = new Node<>(value);
            node.next = first;
            first = node;
            rsl = true;
            size++;
            modCount++;
        }
        return rsl;
    }

    public E get(int index) {
        Node<E> rsl = first;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        modCount++;
        return rsl.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            Node<E> step = first;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return step != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rsl = step.data;
                step = step.next;
                return rsl;
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        public Node(E data) {
            this.data = data;
        }
    }
}
