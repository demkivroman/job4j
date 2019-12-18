package ru.job4j.departure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Departure {
    public static void abs(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void desc(List<String> orgs) {
        orgs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                String[] arro1 = o1.split("\\\\");
                String[] arro2 = o2.split("\\\\");
                int size = arro1.length < arro2.length ? arro1.length : arro2.length;
                for (int i = 0; i < size; i++) {
                    if (!arro1[i].equals(arro2[i])) {
                        result = arro2[i].compareTo(arro1[i]);
                        break;
                    }
                }
                if (result == 0) {
                    result = Integer.compare(arro1.length, arro2.length);
                }
                return result;
            }
        });
    }
    public static void fillGaps(List<String> orgs) {
        int index = 0;
        int lenth = 3;
        for (String st : orgs) {
        String[] arr = st.split("\\\\");
        StringBuilder str = new StringBuilder();
        if (arr.length != lenth) {
            for (int i = 0; i < lenth; i++) {
                if (i < arr.length) {
                    str.append(arr[i] + "\\");
                } else {
                    str.append(arr[arr.length - 1] + "\\");
                }
            }
            orgs.set(index, str.substring(0, str.length() - 1));
        }
        index++;
        }
    }
}
