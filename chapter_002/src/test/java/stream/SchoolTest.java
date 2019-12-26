package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenCheckStudentsClassA() {
        List<Student> students = List.of(
                new Student(5),
                new Student(90),
                new Student(75),
                new Student(1)
        );
        School school = new School();
        List<Student> rsl = school.collect(students,
                student -> student.getScore() >= 70
                        && student.getScore() <= 100);

        List<Integer> expect = List.of(90, 75);

        assertThat(expect,
                is(rsl.stream().map(
                        score -> score.getScore()).
                        collect(Collectors.toList())));
    }
    @Test
    public void whenCheckStudentsClassB() {
        List<Student> students = List.of(
                new Student(50),
                new Student(90),
                new Student(69),
                new Student(51)
        );
        School school = new School();
        List<Student> rsl = school.collect(students,
                student -> student.getScore() >= 50
                        && student.getScore() <= 70);

        List<Integer> expect = List.of(50, 69, 51);

        assertThat(expect,
                is(rsl.stream().map(
                        score -> score.getScore()).
                        collect(Collectors.toList())));
    }
    @Test
    public void whenCheckStudentsClassC() {
        List<Student> students = List.of(
                new Student(50),
                new Student(90),
                new Student(69),
                new Student(51)
        );
        School school = new School();
        List<Student> rsl = school.collect(students,
                student -> student.getScore() >= 0
                        && student.getScore() <= 50);

        List<Integer> expect = List.of(50);

        assertThat(expect,
                is(rsl.stream().map(
                        score -> score.getScore()).
                        collect(Collectors.toList())));
    }
    @Test
    public void whenCheckStudentsListToMap() {
        Student roman = new Student(50, "Roman");
        Student petr = new Student(90, "Petr");
        Student oksana = new Student(69, "Oksana");
        List<Student> students = new ArrayList<>();
        students.add(roman);
        students.add(petr);
        students.add(oksana);
        School school = new School();
        Map<String, Student> rsl = school.collectMap(students);
        Map<String, Student> expect = new LinkedHashMap<>();
        expect.put("Roman", roman);
        expect.put("Petr", petr);
        expect.put("Oksana", oksana);

        assertThat(
                expect,
                is(rsl)
        );
    }
}
