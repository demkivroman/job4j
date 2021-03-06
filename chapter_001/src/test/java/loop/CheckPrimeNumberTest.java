package loop;

import job4j.loop.CheckPrimeNumber;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckPrimeNumberTest {
    @Test
    public void when5() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(5);
        assertThat(rsl, is(true));
    }

    @Test
    public void when4() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(4);
        assertThat(rsl, is(false));
    }

    @Test
    public void when2() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(2);
        assertThat(rsl, is(true));
    }

    @Test
    public void when1() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(1);
        assertThat(rsl, is(false));
    }

}
