package ood.srp;

import java.util.function.Predicate;

/**
 * Отдел бухгалтерии попросил изменить вид зарплаты.
 */
public class ReportForAccounting implements IReportEngine {
    private Store store;
    private final Double coefficient;


    public ReportForAccounting(Store store, Double coefficient) {
        this.store = store;
        this.coefficient = coefficient;
    }

    /**
     * Return employers with salary * coefficient.
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * this.coefficient).append(";");
        }
        return text.toString();
    }

}
