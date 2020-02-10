package conteiner;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicArrayTest {
    private DynamicArray<Integer> container = new DynamicArray<>();

    @Before
    public void beforeTest() {
        container.add(1);
        container.add(2);
        container.add(3);
    }

    @Test
    public void whenCheckAddElem() {
        container.add(4);
        assertThat(
                container.get(0),
                is(1)
        );
        assertThat(
                container.get(3),
                is(4)
        );
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCheckConcurrentException() {
        Iterator<Integer> iter = container.iterator();
        assertThat(
                iter.next(),
                is(1)
        );
        assertThat(
                iter.next(),
                is(2)
        );
        assertThat(
                iter.next(),
                is(3)
        );
        container.add(4);
        iter.next();
    }

}
