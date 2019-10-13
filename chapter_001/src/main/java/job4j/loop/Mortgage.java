package job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent){
        int year = 1;
        double creditAmount = amount + (amount * percent / 100);

        while (creditAmount > salary){
            year++;
            double payed = creditAmount - salary;
            creditAmount =  payed + payed * percent / 100;
        }
        return year;
    }
}
