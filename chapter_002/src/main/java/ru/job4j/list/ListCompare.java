package ru.job4j.list;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int comp = 0;
        int size = Math.min(o1.length(), o2.length());
        for (int i = 0; i < size; i++) {
            comp = Character.compare(o1.charAt(i), o2.charAt(i));
            if (comp != 0) {
                break;
            }
        }

        if (comp == 0 && o1.length() != o2.length()) {
        comp = Integer.compare(o1.length(), o2.length());
        }
        return comp;
    }
}
