package test.sql;

import java.util.List;

public class PrintTest {

    public void printDepartments(List<Department> departments) {
        System.out.println("Departments table\n" +
                "-------------------------");
        departments.forEach(
                line -> {
                    System.out.println(String.format("%d | %s ", line.getId(), line.getName()));
                }
        );
    }

    public void printEmployer(List<Employer> employers) {
        System.out.println("Employers table\n---------------");
        employers.forEach(
                line -> System.out.println(
                        String.format("%d | %d | %s | %s", line.getId(), line.getDep_id(),
                                line.getFirst_name(), line.getLast_name())
                )
        );
    }

    public void printClient(List<Client> clients) {
        System.out.println("Clients table\n--------------");
        clients.forEach(
                line -> System.out.println(
                        String.format("%d | %d | %s", line.getId(), line.getEmp_id(), line.getName())
                )
        );
    }
}
