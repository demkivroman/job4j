package conteiner;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {
    private SimpleStack<Integer> stack = new SimpleStack<>();

    @Before
    public void whenBeforeTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenCheckStackPollOperation() {
        assertThat(
                stack.poll(),
                is(3)
        );
        assertThat(
                stack.poll(),
                is(2)
        );
        assertThat(
                stack.poll(),
                is(1)
        );
        Integer expected = null;
        assertThat(
                stack.poll(),
                is(expected)
        );
    }
}
