package conteiner.map;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap <K, V> implements Iterable {
    int initialCapacity = 1 << 4;
    float loadFactor = 0.75f;
    int maximumCapacity = 1 << 30;
    Node<K,V>[] table;
    int size;
    int threshold;

    public boolean insert(K key, V value) {
        boolean rsl;
        Node<K,V> entry = new Node<>(key, value);
        if (table == null) {
            resize();
        }
        rsl = putValue(entry);

        if (size > threshold) {
            resize();
        }
        return rsl;
    }

    public V get(K key) {
        V rsl = null;
        for (Node<K,V> entry : table) {
            Node<K,V> el = entry;
            do {
                if (el != null) {
                    if (el.key.equals(key)) {
                        rsl = el.value;
                        break;
                    }
                    el = el.next;
                }
            } while (el != null);
        }
        return rsl;
    }

    public boolean delete(K key) {
        boolean rsl = false;
        int i = 0;
        for (Node<K,V> entry : table) {
            Node<K,V> el = entry, next = (el != null) ? el.next : null;
            if (el != null && el.key.equals(key)) {
                table[i] = (el.next != null) ? el.next : null;
                rsl = true;
                size --;
            }
            while (next != null) {
                if (next.key.equals(key)) {
                    el.next = (next.next != null) ? next.next : null;
                    rsl = true;
                    size --;
                    break;
                }
                el = next;
                next = el.next;
            }
            if (rsl) {
                break;
            }
        }
        return rsl;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return (key == null) ? 0 : Objects.hashCode(key) ^ Objects.hashCode(key) >>> 16;
    }

    boolean putValue(Node<K,V> value) {
        boolean rsl = false;
        int index = initialCapacity & hash(value.key);
        index = (index == initialCapacity) ? initialCapacity - 1 : index;
        Node<K,V> cell, nextCell, last =null;
        boolean replace = false;
        if ((cell = table[index]) != null) {
            do {
                if (cell.key.equals(value.key) &&
                Objects.hashCode(cell.key) == Objects.hashCode(value.key)) {
                    cell.value = value.value;
                    replace = true;
                    break;
                }
                nextCell = cell.next;
                last = cell;
            } while ((cell = nextCell) != null);
            if (!replace) {
                last.next = value;
                rsl = true;
                size ++;
            }
        } else {
            table[index] = value;
            rsl = true;
            size ++;
        }
        return rsl;
    }

    private void resize() {
        Node<K,V>[] tab;
        int len;
        if (size >= maximumCapacity) {
            initialCapacity = maximumCapacity;
            threshold = (int) (initialCapacity * loadFactor);
        }
        if (table == null) {
            tab = (Node<K, V>[]) new Node[initialCapacity];
            threshold = (int) (initialCapacity * loadFactor);
        } else {
            len = initialCapacity << 1;
            tab = (Node<K, V>[]) new Node[len];
            initialCapacity = len;
            threshold = (int) (initialCapacity * loadFactor);

            int i = 0;
            for (Node<K,V> entry : table) {
                table[i] = null;
                tab[i++] = entry;
            }
        }
        table = tab;
    }

    public Iterator<Entry<K,V>> iterator() {
        return new Iterator<>() {
            int iterSize = 0;
            int cell = 0;
            Node<K,V> current, next;
            public boolean hasNext() {
                return iterSize < size;
            }
            public Entry<K,V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (next == null) {
                    current = table[cell++];
                    while (current == null) {
                        if (cell == initialCapacity) {
                            break;
                        }
                        current = table[cell++];
                    }
                    next = (current != null) ? current.next : null;
                    iterSize ++;
                } else {
                    current = next;
                    next = current.next;
                    iterSize++;
                }
                return new Entry<>(current.key, current.value);
            }
        };
    }

    static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    /*
    class for iterating through map elements
     */
    public static class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
