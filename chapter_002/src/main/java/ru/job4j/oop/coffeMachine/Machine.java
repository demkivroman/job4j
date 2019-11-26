package ru.job4j.oop.coffeMachine;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
            int remainder = money - price;
            while (remainder > 0) {
                for (int index = 0; index < COINS.length; index++) {
                    if (remainder - COINS[index] >= 0) {
                        remainder -= COINS[index];
                        rsl[size++] = COINS[index];
                    }
                }
            }
        return Arrays.copyOf(rsl, size);
    }
}
