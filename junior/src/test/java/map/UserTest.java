package map;

import conteiner.map.User;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void whenTestUserObjects() {
        Calendar date = new GregorianCalendar(1986, 4, 5);
        User user1 = new User("Roman", 2, date);
        User user2 = new User("Roman", 2, date);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "Object1");
        map.put(user2, "Object2");
        System.out.println(map);
    }
}