package conteiner;

import generic.SimpleArray;

import java.util.Iterator;

public abstract class AbstractStore<K extends Base> implements Store<K> {
    private SimpleArray<Base> array;
    public AbstractStore(int size) {
        array = new SimpleArray<>(size);
    }

    @Override
    public void add(K model) {
        array.add(model);
    }
    @Override
    public boolean replace(String id, Base model) {
        boolean rsl = false;
        int index = findIndex(id);
        if (index >= 0) {
            array.set(index, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        int index = findIndex(id);
        if (index >= 0) {
            array.remove(index);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public K findById(String id) {
        int index = findIndex(id);
        Base rsl = null;
        if (index >= 0) {
            rsl = array.get(index);
        }
        return (K) rsl;
    }
    private int findIndex(String id) {
        int index = -1;
        int step = 0;
        Iterator<Base> iter = array.iterator();
        while (iter.hasNext()) {
            Base el = iter.next();
            if (el.getId().equals(id)) {
                index = step;
                break;
            }
            step++;
        }
        return index;
    }
}
