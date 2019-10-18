package array;

import job4j.area.MatrixCheck;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenDataNotTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', 'X'},
                {' ', ' ', 'X', ' ', 'X'},
                {' ', 'X', ' ', ' ', 'X'},
                {' ', ' ', 'X', ' ', 'X'},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(false));
    }
    @Test
    public void OneMoreTest() {
        char[][] input = {
                {' ', ' ', 'X', ' ', 'X'},
                {' ', ' ', 'X', ' ', 'X'},
                {' ', 'X', ' ', ' ', 'X'},
                {' ', ' ', 'X', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X'},
        };
        boolean result = MatrixCheck.isWin(input);
        assertThat(result, is(true));
    }
}
