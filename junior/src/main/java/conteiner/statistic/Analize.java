package conteiner.statistic;

import java.util.*;

public class Analize {
    public Info diff(List<User> prevoius, List<User> current) {
        int change = 0, add = 0, del = 0;
        Info info = new Info();
        Iterator<User> prevIter = prevoius.iterator();
        User prevUser;
        while (prevIter.hasNext()) {
            prevUser = prevIter.next();
            User curUser;
            Iterator<User> curIter = current.iterator();
            int count = 0;
            while (curIter.hasNext()) {
                curUser = curIter.next();
                if (prevUser.id == curUser.id) {
                    if (!prevUser.name.equals(curUser.name)) {
                        change++;
                        break;
                    } else {
                        break;
                    }
                }
                count++;
            }
            if (count == current.size()) {
                del++;
            }
        }
        Iterator<User> iterAdd = current.iterator();
        User curUser;
        while (iterAdd.hasNext()) {
            curUser = iterAdd.next();
            User prev;
            Iterator<User> iter = prevoius.iterator();
            int count = 0;
            while (iter.hasNext()) {
                prev = iter.next();
                if (curUser.id == prev.id) {
                    break;
                }
                count++;
            }
            if (count == prevoius.size()) {
                add++;
            }
        }
        info.added = add;
        info.changed = change;
        info.deleted = del;
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
