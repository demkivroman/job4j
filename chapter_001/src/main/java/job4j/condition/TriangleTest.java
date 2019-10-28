package job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void triangleArea() {
        Triangle trl = new Triangle(new Point(15, 15), new Point(23, 30), new Point(50, 25));
        double expected = 222.50000000000003;
        assertThat(trl.area(), is(expected));
    }
    @Test
    public void triangleIsNotExist() {
        Triangle trl = new Triangle(new Point(3, 2), new Point(0, 2), new Point(5, 2));
        double expected = -1;
        assertThat(trl.area(), is(expected));
    }

}
