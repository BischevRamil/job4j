package ood.srp;

import java.io.*;
import java.util.function.Predicate;

/**
 * отдел программистов потребовал ответы в виде html.
 */
public class ReportToHTML implements IReportEngine {
    private Store store;
    private static final String TF = System.getProperty("java.io.tmpdir");
    private static final String BR = "<br>";
    private File reportFile = new File(TF + File.separator + "report.html");

    public ReportToHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(BR)
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        writeReportHTML(text);
        return text.toString();
    }

    /**
     * Method generate HTML-file in ${System.tmpdir}/report.html
     * @param text text
     */
    private void writeReportHTML(StringBuilder text) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(reportFile))) {
            out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
