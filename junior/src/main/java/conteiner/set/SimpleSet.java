package conteiner.set;

import conteiner.DynamicList;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private DynamicList<T> list;
    public SimpleSet() {
        this.list = new DynamicList<>();
    }

    public void add(T value) {
        boolean isElement = false;
        Iterator<T> iter = this.list.iterator();
        while (iter.hasNext()) {
            T element = iter.next();
            if (element.equals(value)) {
                isElement = true;
                break;
            }
        }
        if (!isElement) {
            list.add(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
