import list.SimpleArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(
                list.get(1),
                is(2)
        );
    }
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(
                list.getSize(),
                is(3)
        );
    }

    @Test
    public void whenCheckDeleteElement() {
        assertThat(
                list.get(0),
                is(3)
        );
        int rsl = list.delete();
        assertThat(
                rsl,
                is(3)
        );
        assertThat(
                list.get(0),
                is(2)
        );
    }
}
