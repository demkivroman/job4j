package stream.group;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(
                s -> s.getUnits().stream().map(
                        u -> new Holder(u, s.getName())
                )
        ).collect(
                Collectors.groupingBy(
                        t -> t.key,
                        Collector.of(
                                HashSet::new,
                                (set, el) -> set.add(el.value),
                                (left, right) -> { left.addAll(right); return left; }
                        )
                )
        );
    }
    static class Holder {
       String key, value;

        public Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }
}
