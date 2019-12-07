package ru.job4j.list;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(list);
        return result;
    }
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int comp = o1.getName().compareTo(o2.getName());
                return (comp == 0) ? Integer.compare(o1.getAge(), o2.getAge()) : comp;
            }
        });
        return list;
    }

    public static void main(String[] args) {
        List<User> list = new LinkedList<>();
        list.add(new User("Roman2", 2));
        list.add(new User("Roma", 1));
        list.add(new User("Roma3", 3));
        for (User user : new SortUser().sortNameLength(list)) {
            System.out.println(user.getName());
        }

        List<User> list2 = new LinkedList<>();
        list2.add(new User("Serg", 25));
        list2.add(new User("Ivan", 30));
        list2.add(new User("Serg", 20));
        list2.add(new User("Ivan", 25));
        for (User user : new SortUser().sortByAllFields(list2)) {
            System.out.println(String.format("[%s - %d] ", user.getName(), user.getAge()));
        }
    }
}
