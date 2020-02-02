import java.util.Iterator;

public class Converter implements Iterator<Integer> {
    private Iterator<Integer> iterator;

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        while (it.hasNext()) {
            Iterator<Integer> itr = it.next();

        }
        return iterator;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}