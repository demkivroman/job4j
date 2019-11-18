package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.StubInput;
import ru.job4j.tracker.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    private final PrintStream def = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(def);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.askInt("Enter", 1);
        assertThat(
                new String(this.out.toByteArray()),
                is(String.format("Please enter validate data again%n"))
        );
    }

    @Test
    public void whenIllegalStateException() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"90", "2"})
        );
        input.askInt("Enter", 5);
        assertThat(
                new String(this.out.toByteArray()),
                is(String.format("Please select key from menu%n"))
        );
    }
}
