package strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.strategy.Paint;
import ru.job4j.strategy.Square;
import ru.job4j.strategy.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Roman Demkiv (demkivroman5@gmail.com)
 * @version $1$
 * @since 15.11.2019
 */
public class PaintTest {
    // field contain default output to console
    private final PrintStream stdout = System.out;
    // buffer for result
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder().
                                append("x x x x")
                                .append(System.lineSeparator())
                                .append("x x x x")
                                .append(System.lineSeparator())
                                .append("x x x x")
                                .append(System.lineSeparator())
                                .append("x x x x")
                                .append(System.lineSeparator()).toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(new StringBuilder()
                        .append("      x     ")
                        .append(System.lineSeparator())
                        .append("    x x x   ")
                        .append(System.lineSeparator())
                        .append("  x x x x x  ")
                        .append(System.lineSeparator())
                        .append("x x x x x x x ").toString())
        );
    }
}
