package ood.srp;

import java.io.File;
import java.util.function.Predicate;

public class ReportToJSON implements IReportEngine {
    private Store store;
    private static final String TF = System.getProperty("java.io.tmpdir");
    private File reportFile = new File(TF + File.separator + "report.json");

    public ReportToJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();

        for (Employee employee : store.findBy(filter)) {
            text.append("{")
                    .append(System.lineSeparator())
                    .append("\"name\" : \"").append(employee.getName()).append("\",").append(System.lineSeparator())
                    .append("\"hired\" : \"").append(employee.getHired()).append("\",").append(System.lineSeparator())
                    .append("\"fired\" : \"").append(employee.getFired()).append("\",").append(System.lineSeparator())
                    .append("\"salary\" : ").append(employee.getSalary()).append(System.lineSeparator()).append("}");
        }
        WriteReportToFile.write(text, reportFile);
        return text.toString();
    }

}
