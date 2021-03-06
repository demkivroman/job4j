package calculator;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result -> buffer.add(result)
        );

        assertThat(
                buffer,
                is(Arrays.asList(1D, 2D, 3D))
        );
    }
}
