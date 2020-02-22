package conteiner.set;

import conteiner.DynamicList;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

public class SimpleSet<T> implements Iterable<T> {
    private DynamicList<T> list;
    public SimpleSet() {
        this.list = new DynamicList<>();
    }

    public boolean add(T value) {
        boolean rsl = false;
        if (!contains(value)) {
            this.list.add(value);
            rsl = true;
        }
        return rsl;
    }
    public boolean contains(T val) {
        boolean found = false;
        for (T t : list) {
            if (Objects.equals(t, val)) {
                found = true;
                break;
            }
        }
        return found;
    }
    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
