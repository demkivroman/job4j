package ru.job4j.list;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class ConvertListArray {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows != 0 ? list.size() / rows + 1 : list.size() / rows;
        int[][] array = new int[rows][cells];
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
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<Integer>();
        for (int[] arr : list) {
            for (int el : arr) {
                result.add(el);
            }
        }
        return result;
    }
}
