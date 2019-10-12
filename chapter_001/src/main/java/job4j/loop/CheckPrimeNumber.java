package job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num){
        if(num == 1)
            return false;
        int count = 0;
        for (int i = 1; i <= num; i++){
            if ((num % i) == 0){
                count++;
            }
        }
        boolean prime = count > 2 ? false : true;
        return prime;
    }
}
