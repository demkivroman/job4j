package job4j.array;

public class Square {
    public int[] calculate(int bound){
        int[] rst = new int[bound];
        int count = 1;
        for (int i=0; i < bound; i++){
            rst[i] = count * count;
            count++;
        }
        return rst;
    }
}
