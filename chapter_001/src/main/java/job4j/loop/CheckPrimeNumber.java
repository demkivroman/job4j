package job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num) {
        if (num == 1) {
            return false;
        }

        boolean prime = true;


        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
               prime = false;
               break;
            }
        }

        return prime;
    }
}
