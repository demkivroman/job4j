package strategy;

import org.junit.Test;
import ru.job4j.strategy.Square;
import ru.job4j.strategy.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrowSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(new StringBuilder().
                        append("x x x x\n")
                        .append("x x x x\n")
                .append("x x x x\n")
                .append("x x x x\n").toString())
        );
    }
    @Test
    public void whenDrowTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(new StringBuilder()
                .append("      x     \n")
                .append("    x x x   \n")
                .append("  x x x x x  \n")
                .append("x x x x x x x \n").toString())
        );
    }
}
