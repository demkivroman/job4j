package conteiner.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User() {

    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(children);
        result = 31 * result + birthday.hashCode();
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        User userObj = (User) obj;
        return this.name.equals(userObj.name)
                && this.children == userObj.children
                && this.birthday.equals(userObj.birthday);
    }

    public static int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }
}
