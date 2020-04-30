package ood.srp;

import java.util.function.Predicate;

public interface IReportEngine {

    String generate(Predicate<Employee> filter);
}
