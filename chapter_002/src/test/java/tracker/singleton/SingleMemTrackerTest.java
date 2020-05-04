package tracker.singleton;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.singleton.SingleTracker1;
import ru.job4j.tracker.singleton.SingleTracker2;
import ru.job4j.tracker.singleton.SingleTracker3;
import ru.job4j.tracker.singleton.SingleTracker4;

public class SingleTrackerTest {
    @Test
    public void whenCnekSingleTracker1() {
        SingleTracker1 tracker1 = SingleTracker1.getInstance();
        SingleTracker1 tracker2 = SingleTracker1.getInstance();

        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenCheckSingleTracker2() {
        SingleTracker2 tracker1 = SingleTracker2.INSTANCE;
        SingleTracker2 tracker2 = SingleTracker2.INSTANCE;

        assertThat(
                tracker1,
                is(tracker2)
        );
    }

    @Test
    public void whenCheckSingleTracker3() {
        SingleTracker3 tracker1 = SingleTracker3.getInstance();
        SingleTracker3 tracker2 = SingleTracker3.getInstance();

        assertThat(
                tracker1,
                is(tracker2)
        );
    }
    @Test
    public void whenCheckSingleTracker4() {
        SingleTracker4 tracker1 = SingleTracker4.getInstance();
        SingleTracker4 tracker2 = SingleTracker4.getInstance();

        assertThat(
                tracker1,
                is(tracker2)
        );
    }
}
