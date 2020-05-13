package solid;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ReportEngine {
    protected Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary").append(System.lineSeparator());
        for (Employee emp : store.findBy(filter)) {
            text.append(emp.getName()).append(";")
                    .append(emp.getHired()).append(";")
                    .append(emp.getFired()).append(";")
                    .append(emp.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    /**
     * Method for generating report in html view
     * @param filter - predicate as input
     * @return - string in html form as table tags
     */
    public String generateHtmlReport(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th>").append("Name").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Hired").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Fired").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Salary").append("</th>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator());
        for (Employee emp : store.findBy(filter)) {
            text.append("<tr>").append(System.lineSeparator())
                    .append("<td>").append(emp.getName()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(emp.getHired()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(emp.getFired()).append("</td>").append(System.lineSeparator())
                    .append("<td>").append(emp.getSalary()).append("</td>").append(System.lineSeparator())
                    .append("</tr>").append(System.lineSeparator());
        }
        text.append("</table>");
        return text.toString();
    }

    /**
     * Method for generating report in dollars
     * @param filter
     * @return report salary in dollars
     */
    public String generateSalary(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary $").append(System.lineSeparator());
        for (Employee emp : store.findBy(filter)) {
            text.append(emp.getName()).append(";")
                    .append(emp.getHired()).append(";")
                    .append(emp.getFired()).append(";")
                    .append(emp.getSalary()).append("$").append(";");
        }
        return text.toString();
    }

    /**
     * Method for generating report for HR department where name is in
     * descending order by salary
     * @param filter predicator
     * @return only name and salary field
     */
    public String generateForHr(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> emps = store.findBy(filter);
        emps.sort(
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return Double.compare(o2.getSalary(), o1.getSalary());
                    }
                }
        );
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee emp : emps) {
            text.append(emp.getName()).append(";")
                    .append(emp.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
