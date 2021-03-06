package job4j.calculator;

import job4j.calculator.Fit;
import org.junit.Test;
import org.junit.Assert;

public class FitTest {
    @Test
    public void manWeight() {
        double in = 180.00;
        double expected = 92.00;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
    @Test
    public void womanWeight() {
        double in = 180.00;
        double expected = 80.5;
        double out  = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}
