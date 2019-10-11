package loop;
import job4j.loop.Count;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //напишите здесь тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет
        // равна 30.
        Count count = new Count();
        int result = count.add(1,10);
        assertThat(result, is(30));
    }

}
