import java.util.Iterator;

public class MatrixIterator implements Iterator {
    private final int[][] array;
    private int row = 0;
    private int cell = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.array.length > row;
    }

    @Override
    public Object next() {
        int el = this.array[row][cell];
        if (cell < this.array[row].length - 1) {
            cell ++;
        } else {
            cell = 0;
            row ++;
        }
        return el;
    }
}
