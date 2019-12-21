package departure;

import org.junit.Test;
import ru.job4j.departure.Departure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartureTest {
    @Test
    public void whenSortABC() {
        List<String> list = Arrays.asList(
                 "sk1", "sk2", "k1"
        );
        Departure.abs(list);

        List<String> expected = Arrays.asList(
        "k1", "sk1", "sk2"
        );

        assertThat(
                list,
                is(expected)
        );
    }

    @Test
    public void whenSortDesc() {
        List<String> list = Arrays.asList(
                "k1", "sk1", "sk2"
        );
        Departure.desc(list);
        List<String> expected = Arrays.asList(
                "sk2", "sk1", "k1"
        );

        assertThat(
                list,
                is(expected)
        );
    }
    @Test
    public void whenFillGaspMissed() {
        List<String> input = Arrays.asList(
                "k1/sk1"
        );
        List<String> expected = Arrays.asList(
                "k1", "k1/sk1"
        );
        List<String> result = Departure.fillGaps(input);

        assertThat(
                result,
                is(expected)
        );
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departure.fillGaps(input);

        assertThat(
                result,
                is(expect)
        );
    }
}
