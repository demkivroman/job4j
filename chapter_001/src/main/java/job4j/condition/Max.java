package job4j.condition;

public class Max {
    public static int max(int left, int right) {
        int maxResult = (left > right) ? left : right;
        return maxResult;
    }
    public static int max(int first, int second, int third) {
        return max(first, max(second, third));
    }
    public static int max(int first, int second, int third, int forth) {
        return max(first, max(second, third, forth));
    }
}
