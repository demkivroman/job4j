package job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el){
        int rsl = -1;
        for (int index = 0; index < data.length; index++){
            if(data[index] == el){
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * Method for looking for index of an element in bounds
     * @param data - array
     * @param el - found element
     * @param start - position to start search
     * @param finish - position to end search
     * @return - index of found element
     */
    public static int indexOf(int[] data, int el, int start, int finish){
        int rsl = -1;
        for (int index = start; index < finish; index++){
            if(data[index] == el){
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
