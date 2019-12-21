package lamda;

import org.junit.Test;
import ru.job4j.lamda.Lamda;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LamdaTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Lamda function = new Lamda();
        List<Double> result = function.diapason(
                5, 8,
                x -> 2 * x + 1
        );
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(
                result,
                is(expected)
        );
    }
    @Test
    public void  whenSquareFunction() {
        Lamda function = new Lamda();
        List<Double> result = function.diapason(
                5, 8,
                x -> x * x
        );
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(
                result,
                is(expected)
        );
    }
    @Test
    public void whenLogFunction() {
        Lamda function = new Lamda();
        List<Double> result = function.diapason(
                5, 8,
                x -> Math.log(x)
        );
        List<Double> expected = Arrays.asList(1.6094379124341003D, 1.791759469228055D, 1.9459101490553132D);
        assertThat(
                result,
                is(expected)
        );
    }
}
