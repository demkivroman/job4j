package conteiner.set;

import conteiner.DynamicList;

import java.util.Iterator;
import java.util.Optional;

public class SimpleSet<T> implements Iterable<T> {
    private DynamicList<T> list;
    public SimpleSet() {
        this.list = new DynamicList<>();
    }

    public void add(T value) {
        boolean[] arr = {false};
        list.forEach(
                el -> {
                    if (el.equals(value)) {
                        arr[0] = true;
                    }
                }
        );
        if (!arr[0]) {
            list.add(value);
        }
    }
    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
