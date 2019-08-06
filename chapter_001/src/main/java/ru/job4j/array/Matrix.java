package ru.job4j.array;

/**
 * Класс составляющий таблицу Пифагора(умножения).
 * @author Bischev Ramil
 * @since 06-08-2019
 * @version 1.0
 */

public class Matrix {

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
