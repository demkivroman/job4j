package map;

import conteiner.map.SimpleMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {
    private SimpleMap<Integer, String> map = new SimpleMap<>();

    @Before
    public void beforeTest() {
        map.insert(1111, "roman");
        map.insert(22112131, "petr");
        map.insert(3, "oleh");
    }
    @Test
    public void whenChekMapAddEntry() {
        String[] expected = {"roman", "petr", "oleh"};
        String[] actual = new String[map.size()];
        actual[0] = map.get(1111);
        actual[1] = map.get(22112131);
        actual[2] = map.get(3);

        assertThat(
                3,
                is(map.size())
        );
        assertThat(
                actual,
                is(expected)
        );
    }
    @Test
    public void whenCheckAddTheSameItem() {
        map.insert(1111, "andrij");
        String[] expected = {"andrij", "petr", "oleh"};
        String[] actual = new String[map.size()];
        actual[0] = map.get(1111);
        actual[1] = map.get(22112131);
        actual[2] = map.get(3);
        assertThat(
                3,
                is(map.size())
        );
        assertThat(
                actual,
                is(expected)
        );
    }

    @Test
    public void whenCheckSimpleMapDeleteItem() {
        String[] expected = {"roman", null, "oleh"};
        String[] actual = new String[map.size()];
        map.delete(22112131);
        actual[0] = map.get(1111);
        actual[1] = map.get(22112131);
        actual[2] = map.get(3);
        assertThat(
                2,
                is(map.size())
        );
        assertThat(
                actual,
                is(expected)
        );
    }
    @Test
    public void whenCheckIteratorSimpleMap() {
        Iterator<SimpleMap.Node<Integer, String>> iter = map.iterator();
        String[] expected = {"roman", "petr", "oleh"};
        String[] actual = new String[map.size()];
        int i = 0;
        while (iter.hasNext()) {
            actual[i++] = iter.next().getValue();
        }
        Arrays.sort(actual);
        Arrays.sort(expected);
        assertThat(
                expected,
                is(actual)
        );
    }
    @Test
    public void whenCheckDoubleHashTable() {
        map.insert(123, "njnknknk");
        map.insert(1234, "njnknknk");
        map.insert(1235, "njnknknk");
        map.insert(1236, "njnknknk");
        map.insert(1277, "njnknknk");
        map.insert(12789, "njnknknk");
        map.insert(1254783, "njnknknk");
        map.insert(1123, "njnknknk");
        map.insert(111123, "njnknknk");
        map.insert(12223, "njnknknk");
        map.insert(123698741, "njnknknk");
        map.insert(12003, "njnknknk");
        map.insert(100023, "njnknknk");
        map.insert(120253, "njnknknk");

        assertThat(
                map.size(),
                is(17)
        );
    }
}
