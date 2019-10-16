package job4j.array;

public class Turn {
    public int[] back(int[] array){
        for(int index=0; index < array.length / 2; index++){
            int last = array.length-index-1;
            int temp = array[index];
            array[index] = array[last];
            array[last] = temp;
        }
        return array;
    }
}
