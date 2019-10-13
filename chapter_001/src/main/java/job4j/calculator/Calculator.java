package job4j.calculator;

/**
 * Class for making aryphmetic operations
 * @author demkiv
 * @since 12.10.2019
 * @version 1
 */
public class Calculator {
    /**
     * @param first first parameter
     * @param second second parameter
     * @return result of adding operation
     */
    public static void add(double first, double second){
        double result = first + second;
        System.out.println(first + "+" + second + "=" + result);
    }

    /**
     * @param first
     * @param second
     * @return result of dividing operation
     */
    public static void div(double first, double second){
        double result = first / second;
        System.out.println(first + "/" + second + "=" + result);
    }

    /**
     * @param first
     * @param second
     * @return result of multiplying operation
     */
    public static void multiply(double first, double second){
        double result = first * second;
        System.out.println(first + "*" + second + "=" + result);
    }

    /**
     * @param first
     * @param second
     * @return result of substrackt operation
     */
    public static void subtrack(double first, double second){
        double result = first - second;
        System.out.println(first + "-" + second + "=" + result);
    }

    /**
     * Method main accomplish mathemetic operation
     * @param args
     */
    public static void main(String[] args){
        add(1,1);
        div(4,2);
        multiply(2,1);
        subtrack(10,5);
    }

}
