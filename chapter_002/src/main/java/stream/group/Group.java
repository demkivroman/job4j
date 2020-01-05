package stream.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(
                el -> {
                    List<Holder> lst = new ArrayList<>();
                    el.getUnits().forEach(
                            elem -> lst.add(new Holder(elem, el.getName()))
                    );
                    return Stream.of(lst);
                }
        ).collect(
                Collectors.toMap(
                        
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
