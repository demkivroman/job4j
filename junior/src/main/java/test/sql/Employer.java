package test.sql;

public class Employer {
    private int id;
    private int dep_id;
    private String first_name;
    private String last_name;

    public Employer(int id, int dep_id, String first_name, String last_name) {
        this.id = id;
        this.dep_id = dep_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public int getDep_id() {
        return dep_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
