package conteiner;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicListTest {
    private DynamicList<Integer> dList = new DynamicList<>();

    @Before
    public void beforeTest() {
        dList.add(1);
        dList.add(2);
        dList.add(3);
    }

    @Test
    public void whenCheckAddAndGetOperation() {
        assertThat(
                dList.get(1),
                is(2)
        );
    }

    @Test
    public void whenCheckIterator() {
        Iterator<Integer> iter = dList.iterator();
        assertThat(
                iter.next(),
                is(3)
        );
        assertThat(
                iter.next(),
                is(2)
        );
        assertThat(
                iter.next(),
                is(1)
        );
    }
    @Test(expected = ConcurrentModificationException.class)
    public void whenCheckConcurrentExe() {
        Iterator<Integer> iter = dList.iterator();
        dList.add(4);
        iter.next();
    }
}
