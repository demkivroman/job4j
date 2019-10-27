package ru.job4j.condition;

import job4j.condition.SqMax;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void maxFirst() {
        int result = SqMax.max(100, 5, 10, 2);
        assertThat(result, is(100));
    }
    @Test
    public void maxSecond() {
        int result = SqMax.max(1, 50, 10, 2);
        assertThat(result, is(50));
    }
    @Test
    public void maxThird() {
        int result = SqMax.max(1, 5, 10, 2);
        assertThat(result, is(10));
    }
    @Test
    public void maxForth() {
        int result = SqMax.max(100, 5, 10, 200);
        assertThat(result, is(200));
    }
    @Test
    public void allEqual() {
        int result = SqMax.max(100, 100, 100, 100);
        assertThat(result, is(100));
    }
}
