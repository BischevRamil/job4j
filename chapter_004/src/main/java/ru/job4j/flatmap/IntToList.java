package ru.job4j.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ramil bischev
 * @since 2019-10-02
 * метод преобразовывает двумерный массив в список с помощью Stream
 */
public class IntToList {

    List<Integer> convertIntToList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
