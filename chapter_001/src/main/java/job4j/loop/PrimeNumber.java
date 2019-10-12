package job4j.loop;

public class PrimeNumber {
    public int calc(int finish){
        int count = 0;
        boolean prime = false;
        for (int i=2; i <= finish; i++){
            int countCoin = 0;
            for (int j = 1; j <= i; j++){
                if (i % j == 0){
                    countCoin ++;
                }
            }
            if(countCoin <= 2)
                count++;
        }
        return count;
    }
}
