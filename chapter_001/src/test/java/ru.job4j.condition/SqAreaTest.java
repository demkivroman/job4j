package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {
    @Test
    public void square(){
        int in_p = 6;
        int in_k = 2;
        int expected = 2;
        double out = SqArea.square(in_p, in_k);
        Assert.assertEquals(expected, out, 0.01);
    }
}
