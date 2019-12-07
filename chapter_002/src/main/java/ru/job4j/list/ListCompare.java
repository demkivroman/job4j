package ru.job4j.list;

import java.util.Comparator;

public class ListCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int comp = 0;
        String ob1 = (String) o1;
        String ob2 = (String) o2;
        int size = (ob1.length() < ob2.length()) ? ob1.length() : ob2.length();
        for (int i = 0; i < size; i++) {
            comp = Character.compare(ob1.charAt(i), ob2.charAt(i));
            if (comp != 0) {
                break;
            }
        }
        if (comp == 0 && ob1.length() != ob2.length()) {
            comp = (ob1.length() < ob2.length()) ? -1 : 1;
        }
        return comp;
    }
}
