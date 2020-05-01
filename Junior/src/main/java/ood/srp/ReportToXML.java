package ood.srp;

import java.io.File;
import java.util.function.Predicate;

public class ReportToXML implements IReportEngine {
    private Store store;
    private static final String TF = System.getProperty("java.io.tmpdir");
    private File reportFile = new File(TF + File.separator + "report.xml");

    public ReportToXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        text.append("<Employers>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<Name>").append(employee.getName()).append("</Name>")
                    .append("<Hired>").append(employee.getHired()).append("</Hired>")
                    .append("<Fired>").append(employee.getFired()).append("</Fired>")
                    .append("<Salary>").append(employee.getSalary()).append("</Salary>");
        }
        text.append("</Employers>");
        WriteReportToFile.write(text, reportFile);
        return text.toString();
    }
}
