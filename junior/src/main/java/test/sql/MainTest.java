package test.sql;

public class MainTest {

    public static void main(String[] args) {
        Config config = new Config();
        StoreSQLTest sqlTest = new StoreSQLTest(config);
       // sqlTest.fillDepartments();
       // sqlTest.fillEmployer();
        sqlTest.fillClient();
        PrintTest print = new PrintTest();
        RetrieveTest retrieveTest = new RetrieveTest(config);
        print.printDepartments(retrieveTest.getAllDepartments());
        print.printEmployer(retrieveTest.getAllEmployers());
        print.printClient(retrieveTest.getAllClients());
        try {
            sqlTest.close();
            retrieveTest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
