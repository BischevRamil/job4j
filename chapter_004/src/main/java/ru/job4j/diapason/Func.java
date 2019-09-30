package ru.job4j.diapason;

import java.util.ArrayList;
import java.util.List;

public class Func {

    public interface Operation {
        double calc(double value);
    }

    public static List<Double> diapason(int start, int end, Operation func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(func.calc(i));
        }
        return list;
    }
}
