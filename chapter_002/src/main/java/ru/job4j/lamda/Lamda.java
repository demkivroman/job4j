package ru.job4j.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Lamda {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != end; index++) {
            result.add(func.apply(Double.valueOf(index)));
        }
        return result;
    }
}
