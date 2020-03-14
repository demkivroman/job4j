package conteiner.statistic;

import java.util.*;

public class Analize {
    public Info diff(List<User> prevoius, List<User> current) {
        int change = 0, add = 0;
        Info info = new Info();
        Map<Integer, User> mapPrev = new HashMap<>();
        prevoius.forEach(
                el -> mapPrev.put(el.id, el)
        );

        for (User entry : current) {
            User user = mapPrev.remove(entry.id);
            if (user == null) {
                add++;
            } else if (!user.name.equals(entry.name)) {
                change++;
            }
        }
        info.added = add;
        info.changed = change;
        info.deleted = mapPrev.size();
        return info;
    }
    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
