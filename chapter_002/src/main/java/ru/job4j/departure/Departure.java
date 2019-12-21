package ru.job4j.departure;

import java.lang.reflect.Array;
import java.util.*;

public class Departure {
    public static void abs(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void desc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
             start += el;
             tmp.add(start);
             start = start + "/";
            }
        }
        return new ArrayList<>(tmp);
    }
}
