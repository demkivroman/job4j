package stream;

public class Student implements Comparable<Student> {
    private int score;
    private String name;

    public Student(int score) {
        this.score = score;
    }

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, this.score);
    }
}
