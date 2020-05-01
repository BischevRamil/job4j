package ood.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.time.LocalDate;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        IReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        IReportEngine engine = new ReportToHTML(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append("<br>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForAccounting() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        IReportEngine engine = new ReportForAccounting(store, 1.5);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("150.0").append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Petr", now, now, 132);
        Employee worker2 = new Employee("Sasha", now, now, 80);
        Employee worker3 = new Employee("Maria", now, now, 95);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        IReportEngine engine = new ReportForHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        IReportEngine engine = new ReportToXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<Employers>")
                .append("<Name>").append(worker.getName()).append("</Name>")
                .append("<Hired>").append(worker.getHired()).append("</Hired>")
                .append("<Fired>").append(worker.getFired()).append("</Fired>")
                .append("<Salary>").append(worker.getSalary()).append("</Salary>")
                .append("</Employers>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        LocalDate now = LocalDate.now();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        IReportEngine engine = new ReportToJSON(store);
        StringBuilder expect = new StringBuilder()
                .append("{").append(System.lineSeparator())
                .append("\"name\" : \"").append(worker.getName()).append("\",").append(System.lineSeparator())
                .append("\"hired\" : \"").append(worker.getHired()).append("\",").append(System.lineSeparator())
                .append("\"fired\" : \"").append(worker.getFired()).append("\",").append(System.lineSeparator())
                .append("\"salary\" : ").append(worker.getSalary()).append(System.lineSeparator()).append("}");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
