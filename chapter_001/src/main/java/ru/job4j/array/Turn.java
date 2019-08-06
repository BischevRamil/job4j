package ru.job4j.array;

/**
 * Переворот массива.
 * @author Bischev Ramil
 * @since 05-08-2019
 * @version 1.0
 */

public class Turn {
    public int[] back(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
