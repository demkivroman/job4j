package conteiner.statistic;

import java.util.List;

public class Analize {
    public Info diff(List<User> prevoius, List<User> current) {
        int diff;
        Info info = new Info();
        info.deleted = ((diff = (prevoius.size() - current.size())) < 0) ? 0 : diff;
        info.added = (diff < 0) ? Math.abs(diff) : 0;
        info.changed = findDifference(prevoius, current);
        return info;
    }
    int findDifference(List<User> previous, List<User> current) {
        int rsl = 0;
        for (int index = 0; index < current.size(); index++) {
            User prevUser = index < previous.size() ? previous.get(index) : null;
            User curUser = current.get(index);
            if (prevUser == null) {
                break;
            }
            if (prevUser.id == curUser.id && !prevUser.name.equals(curUser.name)) {
                rsl++;
            }
        }
        return rsl;
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
