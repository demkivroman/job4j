package strategy;

import org.junit.Test;
import ru.job4j.strategy.Paint;
import ru.job4j.strategy.Square;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(stdout);
    }
}
