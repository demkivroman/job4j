package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student st = new Student();
        st.setFullName("Demkiv Roman Vasulovuch");
        st.setGroup("Trainee");
        st.setEntranceDate(new Date());
        System.out.println("Student " + st.getFullName() + " started course in " + st.getEntranceDate() + " at group: " + st.getGroup());
    }
}
