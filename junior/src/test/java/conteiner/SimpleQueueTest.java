package conteiner;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue = new SimpleQueue<>();

    @Before
    public void beforeTest() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }
    @Test
    public void whenCheckPollOperation() {
        assertThat(
                queue.poll(),
                is(1)
        );
        assertThat(
                queue.poll(),
                is(2)
        );
        queue.push(4);
        queue.push(5);
        assertThat(
                queue.poll(),
                is(3)
        );
        assertThat(
                queue.poll(),
                is(4)
        );
        assertThat(queue.poll(), is(5));
        Integer expect = null;
        assertThat(
                queue.poll(),
                is(expect)
        );
    }
}
