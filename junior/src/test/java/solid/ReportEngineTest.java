package solid;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Calendar;

public class ReportEngineTest {
    @Test
    public void whenOldGenereted() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");

        assertThat(
                engine.generate(em -> true),
                is(expect.toString())
        );
    }

    /**
     * Test method for check html report
     */
    @Test
    public void whenHtmlGenereted() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<table>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<th>").append("Name").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Hired").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Fired").append("</th>").append(System.lineSeparator())
                .append("<th>").append("Salary").append("</th>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator())
                .append("<tr>").append(System.lineSeparator())
                .append("<td>").append(worker.getName()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker.getHired()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker.getFired()).append("</td>").append(System.lineSeparator())
                .append("<td>").append(worker.getSalary()).append("</td>").append(System.lineSeparator())
                .append("</tr>").append(System.lineSeparator())
                .append("</table>");

        assertThat(
                engine.generateHtmlReport(em -> true),
                is(expect.toString())
        );
    }

    @Test
    public void whenNewSalaryGenereted() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary $")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append("$").append(";");

        assertThat(
                engine.generateSalary(em -> true),
                is(expect.toString())
        );
    }

    @Test
    public void whenCheckEmployeesInDescendingOrder() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee roman = new Employee("Roman", now, now, 100);
        Employee ivan = new Employee("Ivan", now, now, 300);
        Employee andrey = new Employee("Andrey", now, now, 1000);
        store.add(roman);
        store.add(ivan);
        store.add(andrey);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(andrey.getName()).append(";")
                .append(andrey.getSalary()).append(";").append(System.lineSeparator())
                .append(ivan.getName()).append(";")
                .append(ivan.getSalary()).append(";").append(System.lineSeparator())
                .append(roman.getName()).append(";")
                .append(roman.getSalary()).append(";").append(System.lineSeparator());

        assertThat(
                engine.generateForHr(em -> true),
                is(expect.toString())
        );
    }
}
