package ru.job4j.list;

import java.lang.reflect.Array;
import java.util.List;

public class ConvertListArray {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows != 0 ? list.size() / rows + 1 : list.size() / rows;
        int [][] array = new int[rows][cells];
        int index = 0;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cells; y++) {
                if (index < list.size()) {
                    array[x][y] = list.get(index++);
                } else {
                    array[x][y] = 0;
                }

            }
        }
        return array;
    }
}
