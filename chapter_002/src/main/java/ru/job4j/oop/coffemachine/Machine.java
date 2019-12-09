package ru.job4j.oop.coffemachine;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
            int remainder = money - price;
            while (remainder > 0) {
                for (int index = 0; index < coins.length; index++) {
                    if (remainder - coins[index] >= 0) {
                        remainder -= coins[index];
                        rsl[size++] = coins[index];
                    }
                }
            }
        return Arrays.copyOf(rsl, size);
    }
}
