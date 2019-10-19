package job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean tample = data[0];
        for (int index = 0; index < data.length; index++) {
            if (data[index] != tample) {
                result = false;
                break;
            }
        }
        return result;
    }
}
