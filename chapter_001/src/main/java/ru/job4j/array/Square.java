package ru.job4j.array;

/**
 * Класс для наполнения массива квадратами чисел
 * @author Bischev Ramil
 * @since 05-08-2019
 * @version 1.0
 */

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int j=1;
        for(int i=0; i<bound; i++) {
            rst[i]=j*j;
            j++;
        }
        return rst;
    }
}
