package list;

import org.junit.Test;
import ru.job4j.list.ListCompare;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StringsCompareTest {
    @Test
    public void whenStringsAreEqualThenZero () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
          "Ivanov",
          "Ivanov"
        );
        assertThat(
                rst,
                is(0)
        );
    }
    @Test
    public void whenLeftLessThanRightResultShouldBeNegative () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(
                rst,
                lessThan(0)
        );
    }
    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }
    @Test
    public void when123 () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "123",
                "12345"
        );
        assertThat(
                rst,
                lessThan(0)
        );
    }
}
