package stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenCheckConvertMatrixToList() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix matrixOb = new Matrix();
        List<Integer> rsl = matrixOb.convertMatrixToList(matrix);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertThat(
                expect,
                is(rsl)
        );
    }
}
