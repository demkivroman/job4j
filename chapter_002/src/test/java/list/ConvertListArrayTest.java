package list;

import org.junit.Test;
import ru.job4j.list.ConvertListArray;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertListArray list = new ConvertListArray();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
    }
}
