package set;

import conteiner.set.SimpleSet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    private SimpleSet<Integer> set = new SimpleSet<>();

    @Before
    public void beforeTest() {
        this.set.add(1);
        this.set.add(2);
        this.set.add(3);
        this.set.add(2);
    }

    @Test
    public void whenCheckSetContainsSameValue() {
        Iterator<Integer> iter = this.set.iterator();
        List<Integer> list = new ArrayList<>();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        List<Integer> expected = Arrays.asList(3, 2, 1);

        assertThat(
                list,
                is(expected)
        );
    }
}
