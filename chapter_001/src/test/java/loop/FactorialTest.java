package loop;
import job4j.loop.Factorial;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
         Factorial f = new Factorial();
         int result = f.calc(5);
         assertThat(result, is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial f = new Factorial();
        int result = f.calc(0);
        assertThat(result, is(1));
    }

    @Test
    public void whenCalculateFactorialForOneThenOne(){
        Factorial f = new Factorial();
        int result = f.calc(1);
        assertThat(result, is(1));
    }

}
