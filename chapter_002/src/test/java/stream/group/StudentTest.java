package stream.group;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void whenCheckGroupStudent() {
        List<Student> students = List.of(
                new Student("Roman", Set.of("football", "tenis", "swimming", "chess")),
                new Student("Petro", Set.of("tenis", "swimming", "chess")),
                new Student("Oleh", Set.of("chess")),
                new Student("Oksana", Set.of("football", "tenis", "swimming", "chess"))
        );
        Map<String, Set<String>> rsl = Group.sections(students);
        Map<String, Set<String>> expected = Map.of(
                "football", Set.of("Roman", "Oksana"),
                "tenis", Set.of("Roman", "Petro", "Oksana"),
                "swimming", Set.of("Roman", "Petro", "Oksana"),
                "chess", Set.of("Roman", "Petro", "Oleh", "Oksana")
        );

        assertThat(
                rsl,
                is(expected)
        );
    }
}
