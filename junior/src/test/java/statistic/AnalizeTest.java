package statistic;
import conteiner.statistic.Analize;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {
    private List<Analize.User> previous = new ArrayList<>();

    @Before
    public void beforeTest() {
        previous.add(new Analize.User(1, "Roman"));
        previous.add(new Analize.User(2, "Petr"));
        previous.add(new Analize.User(3, "Andrey"));
    }

    @Test
    public void whenCheckAddAnalyze() {
        List<Analize.User> current = new ArrayList<>(previous);
        current.add(new Analize.User(4, "Rail"));
        current.add(new Analize.User(5, "Vasyl"));
        Analize.Info rsl = new Analize().diff(previous, current);
        assertThat(
                rsl.getAdded(),
                is(2)
        );
        assertThat(
                rsl.getChanged(),
                is(0)
        );
        assertThat(
                rsl.getDeleted(),
                is(0)
        );
    }
    @Test
    public void whenCheckDeleteAnalyze() {
        List<Analize.User> current = new ArrayList<>(previous);
        current.remove(2);
        current.remove(1);
        Analize.Info rsl = new Analize().diff(previous, current);
        assertThat(
                rsl.getDeleted(),
                is(2)
        );
        assertThat(
                rsl.getChanged(),
                is(0)
        );
        assertThat(
                rsl.getAdded(),
                is(0)
        );
    }
    @Test
    public void whenCheckChanged() {
        List<Analize.User> current = new ArrayList<>(previous);
        current.set(1, new Analize.User(2, "Oksana"));
        current.set(2, new Analize.User(3, "Oleh"));
        Analize.Info rsl = new Analize().diff(previous, current);
        assertThat(
                rsl.getChanged(),
                is(2)
        );
        assertThat(
                rsl.getDeleted(),
                is(0)
        );
        assertThat(
                rsl.getAdded(),
                is(0)
        );
    }
    @Test
    public void whenCheckSetAndAddAnalyze() {
        List<Analize.User> current = new ArrayList<>(previous);
        current.set(1, new Analize.User(2, "Oksana"));
        current.set(2, new Analize.User(3, "Oleh"));
        current.add(new Analize.User(6, "Vasul"));
        Analize.Info rsl = new Analize().diff(previous, current);
        assertThat(
                rsl.getChanged(),
                is(2)
        );
        assertThat(
                rsl.getDeleted(),
                is(0)
        );
        assertThat(
                rsl.getAdded(),
                is(1)
        );
    }
}
