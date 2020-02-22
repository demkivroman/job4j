package map;

import conteiner.map.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class UserTest {
    @Test
    public void whenTestUserObjects() {
        Calendar date = new GregorianCalendar(1986, 4, 5);
        User user1 = new User("Roman", 2, date);
        User user2 = new User("Roman", 2, date);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "Object1");
        map.put(user2, "Object2");
  //      System.out.println(map);
    //    System.out.println(user1.hashCode());
   //     System.out.println(user2.hashCode());
        String[] arr = {"roman", "demkiv", "oleh", "vasul", "petro", "hgvhgvhvh", "kjbjbjjbjbj",
        "vgvgvhhhhvhvhv", "xcxcxczdzdzd", "vgvhvhvvhv"};
        Stream.of(arr).forEach(
                entry -> {
                    System.out.print(
                            Objects.hashCode(entry) % 15 + "  ");
                    System.out.print((Objects.hashCode(entry) & Objects.hashCode(15)) + "  |");
                }
        );
        System.out.println();
        Stream.of(arr).forEach(
                entry -> {
                    System.out.print(
                            User.hash(entry) % 15 + "  ");
                    System.out.print((User.hash(entry) & Objects.hashCode(15)) + "  |");
                }
        );
        System.out.println();
        System.out.println(16 << 1);
    }
}
