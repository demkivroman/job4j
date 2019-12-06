package ru.job4j.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>(list);
        return result;
    }

    public static void main(String[] args) {
        List<User> list = new LinkedList<>();
        list.add(new User("Roman2", 2));
        list.add(new User("Roman1", 1));
        list.add(new User("Roman3", 3));
        for (User user : new SortUser().sort(list)) {
            System.out.println(user.getName());
        }
    }
}
