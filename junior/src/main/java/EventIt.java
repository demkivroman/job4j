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
        return (this.findElement(index) < 0) ? false : true;
    }
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        index = this.findElement(index);
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
