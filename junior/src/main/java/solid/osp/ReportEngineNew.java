package solid.osp;
import org.json.JSONObject;
import solid.Employee;
import solid.MemStore;
import solid.ReportEngine;
import solid.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineNew extends ReportEngine {

    public ReportEngineNew(Store store) {
        super(store);
    }

    /**
     * Method for generating XML format of employee report
     * @param filter
     * @return - String in XML
     * @throws JAXBException
     */
    public String generateXml(Predicate<Employee> filter) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        for (Employee emp : store.findBy(filter)) {
            marshaller.marshal(emp, writer);
        }
        return writer.toString();
    }

    /**
     * Method that generate JSON format for report
     * @param filter - predicate
     * @return - string in JSON format
     */
    public String generateJSON(Predicate<Employee> filter) {
        JSONObject jobj = new JSONObject();
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee emp : store.findBy(filter)) {
            jobj.put("name", emp.getName());
            jobj.put("hired", emp.getHired());
            jobj.put("fired", emp.getFired());
            jobj.put("salary", emp.getSalary());
            stringBuilder.append(jobj.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee roman = new Employee("Roman", now, now, 100);
        Employee ivan = new Employee("Ivan", now, now, 300);
        Employee andrey = new Employee("Andrey", now, now, 1000);
        store.add(roman);
        store.add(ivan);
        store.add(andrey);
        ReportEngineNew repEngine = new ReportEngineNew(store);
        System.out.println(repEngine.generateJSON(em -> true));
    }
}
