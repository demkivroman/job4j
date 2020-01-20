package generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {
    private SimpleArray<Integer> arr;

    @Before
    public void setUp() {
        arr = new SimpleArray<>(3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCheckAddElementToObject() {
        this.arr.add(1);
        this.arr.add(2);
        Integer rsl = this.arr.get(1);

        assertThat(
                rsl,
                is(2)
        );
        this.arr.add(3);
        this.arr.add(4);
    }
    @Test
    public void whenCheckSetElementToObject() {
        this.arr.add(1);
        this.arr.add(2);
        this.arr.add(3);
        assertThat(
                this.arr.get(2),
                is(3)
        );
        this.arr.set(2, 10);
        assertThat(
                this.arr.get(2),
                is(10)
        );
    }

    @Test
    public void whenCheckRemoveElementOfObject() {
        this.arr.add(1);
        this.arr.add(2);
        this.arr.add(3);
        this.arr.remove(1);
        assertThat(
                this.arr.get(1),
                is(3)
        );
        Integer ex = null;
        assertThat(
                this.arr.get(2),
                is(ex)
        );
        this.arr.add(5);
        assertThat(
                this.arr.get(2),
                is(5)
        );
        this.arr.remove(2);
        assertThat(
                this.arr.get(2),
                is(ex)
        );
        this.arr.remove(1);
        assertThat(
                this.arr.get(1),
                is(ex)
        );
        this.arr.remove(0);
        assertThat(
                this.arr.get(0),
                is(ex)
        );
    }

    @Test
    public void whenCheckIterator() {
        this.arr.add(1);
        this.arr.add(2);
        this.arr.add(3);
        Iterator<Integer> it = this.arr.iterator();

        assertThat(
                it.hasNext(),
                is(true)
        );
        assertThat(
                it.next(),
                is(1)
        );
        assertThat(
                it.hasNext(),
                is(true)
        );
        assertThat(
                it.next(),
                is(2)
        );
        assertThat(
                it.next(),
                is(3)
        );
        assertThat(
                it.hasNext(),
                is(false)
        );

    }

}
