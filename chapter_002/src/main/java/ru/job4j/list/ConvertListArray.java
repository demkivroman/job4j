package ru.job4j.list;

import java.lang.reflect.Array;
import java.util.List;

public class ConvertListArray {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows != 0 ? list.size() / rows + 1 : list.size() / rows;
        int [][] array = new int[rows][cells];
        int x = 0, y = 0;
        for (int el : list) {
            if (y == cells) {
                x++;
                y = 0;
            }
            array[x][y++] = el;
        }

        return array;
    }
}
