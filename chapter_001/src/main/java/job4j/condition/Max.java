package job4j.condition;

public class Max {
    public static int max(int left, int right) {
        int maxResult = (left > right) ? left : right;
        return maxResult;
    }
    public static int max(int first, int second, int third) {
        int tmp = max(first, second);
        return (tmp > third) ? tmp : third;
    }
    public static int max(int first, int second, int third, int forth) {
        int tmp = max(first, second, third);
        return (tmp > forth) ? tmp : forth;
    }
}
