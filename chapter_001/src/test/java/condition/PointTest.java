package condition;

import job4j.condition.Point;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void whenDistance2D() {
        Point a = new Point(15, 15);
        Point b = new Point(23, 30);
        double dist = a.distance(b);
        double expect = 17.0;
        assertThat(expect, is(dist));
    }
    @Test
    public void whenDistance3D() {
        Point a = new Point(15, 15, 25);
        Point b = new Point(23, 30, 26);
        double dist = a.distanse3d(b);
        double expect = 17.029386365926403;
        assertThat(expect, is(dist));
    }
}
