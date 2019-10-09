package job4j.condition;

public class Max {
    public static int max(int left, int right){
        int maxResult = (left > right) ? left : right;
        return maxResult;
    }
}
