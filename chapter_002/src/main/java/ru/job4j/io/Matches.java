package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        boolean run = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Game \"Matches\":\n-------------");
        while (run) {
            System.out.println("Remaine " + matches + " matches");
            System.out.println("First player take matches:\ninput figure 0-3:");
            int select = Integer.valueOf(input.nextLine());
            matches -= select;
            if (matches > 0) {
                System.out.println("Remaine " + matches + " matches");
                System.out.println("Second player take matches:\ninput figure 0-3:");
                select = Integer.valueOf(input.nextLine());
                matches -= select;
                if (matches <= 0) {
                    System.out.println("Grate!!!\nSecond player win )))");
                    run = false;
                }
            } else {
                System.out.println("Grate!!!\nFirst player win )))");
                run = false;
            }
        }
    }
}
