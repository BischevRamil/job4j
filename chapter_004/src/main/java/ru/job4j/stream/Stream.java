package ru.job4j.stream;

import java.util.ArrayList;

/**
 * @author ramil bischev
 * @since 06.10.2019
 * Класс вычисляет сумму квадратов четных чисел в наборе целочисленных данных.
 */
public class Stream {

    public Integer streamAPI(ArrayList<Integer> array) {
        return array.stream()
                .filter(a -> a % 2 == 0)
                .map(a -> a * a)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
