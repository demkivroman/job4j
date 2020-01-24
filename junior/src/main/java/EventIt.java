import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt implements Iterator {
    private final int[] array;
    private int index = 0;

    public EventIt(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        int indexOfElement = this.findElement(index);
        if (indexOfElement > -1) {
            rsl = true;
            this.index = indexOfElement;
        }
        return rsl;
    }
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.array[index++];
    }
    private int findElement(int index) {
        int result = -1;
        for (int i = index; i < this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

}
