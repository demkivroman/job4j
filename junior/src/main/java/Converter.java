import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {
            private Iterator<Integer> iter = it.next();

            @Override
            public boolean hasNext() {
                if (it.hasNext() && !iter.hasNext()) {
                    iter = it.next();
                }
                return iter.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return iter.next();
            }
        };
    }

}