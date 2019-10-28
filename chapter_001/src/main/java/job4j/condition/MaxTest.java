package job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMaxFromThree() {
       int result = Max.max(6, 2, 0);
       assertThat(result, is(6));
    }

    @Test
    public void whenMaxFromForth() {
        int result = Max.max(1, 2, 10, 0);
        assertThat(result, is(10));
    }
    @Test
    public void whenAllEqual() {
        int result = Max.max(2, 2, 2, 2);
        assertThat(result, is(2));
    }
}
