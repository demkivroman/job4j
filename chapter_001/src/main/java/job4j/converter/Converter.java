package job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;

    }
    public static int rubleToDollar(int value) {
        return value / 60;
    }
    public static int euroToRuble(int value) {
        return value * 70;
    }
    public static int dollarToRuble(int value) {
        return value * 60;
    }
    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToDollar(in);
        boolean passed = expected == out;
        System.out.println(in + " rubles are " + expected + " dollars. Test result: " + passed);
        in = 2;
        expected = 140;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println(in + " euros are " + expected + " rubles. Test result: " + passed);
        in = 2;
        expected = 120;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println(in + " dollars are " + expected + " rubles. Test result: " + passed);
    }
}
