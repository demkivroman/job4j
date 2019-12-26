package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public List<Integer> convertMatrixToList(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(
                el -> Arrays.stream(el)
        ).collect(Collectors.toList());
    }
}
