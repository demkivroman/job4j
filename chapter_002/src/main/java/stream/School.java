package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = students.stream().filter(predict).
                collect(Collectors.toList());
        return result;
    }
    public Map<String, Student> collectMap(List<Student> list) {
        return list.stream().distinct().collect(
                Collectors.toMap(
                        key -> key.getName(),
                        value -> value
                )
        );
    }
    public List<Student> levelOf(List<Student> students, int bound) {
        Collections.sort(students);
        return students.stream().flatMap(Stream::ofNullable).takeWhile(
                el -> el.getScore() > bound)
                .collect(Collectors.toList());
    }
}
