package conteiner;

import generic.SimpleArray;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;

public abstract class AbstractStore<K> implements Store {
    private SimpleArray<Base> array;
    public AbstractStore(int size) {
        array = new SimpleArray<>(size);
    }
    @Override
    public void add(Base model) {
        if (checkType(model)) {
            array.add(model);
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public boolean replace(String id, Base model) {
        if (!checkType(model)) {
            throw new ClassCastException();
        }
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
    public Base findById(String id) {
        int index = findIndex(id);
        Base rsl = null;
        if (index >= 0) {
            rsl = array.get(index);
        }
        return rsl;
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

    private boolean checkType(Base model) {
        return model.getClass().getCanonicalName().equals(
                ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName());
    }
}
