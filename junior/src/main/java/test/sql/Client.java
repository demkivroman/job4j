package test.sql;

public class Client {
    private int id;
    private int emp_id;
    private String name;

    public Client(int id, int emp_id, String name) {
        this.id = id;
        this.emp_id = emp_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getName() {
        return name;
    }
}
