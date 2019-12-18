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
                 "k1", "sk1", "sk2"
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
    public void whenFillGasp() {
        List<String> list = Arrays.asList(
                "K1", "K2\\SK1", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        );
        Departure.fillGaps(list);
        List<String> expected = Arrays.asList(
                "K1\\K1\\K1", "K2\\SK1\\SK1", "K1\\SK1\\SK1", "K1\\SK2\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2\\K2\\K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        );

        assertThat(
                list,
                is(expected)
        );
    }
}
