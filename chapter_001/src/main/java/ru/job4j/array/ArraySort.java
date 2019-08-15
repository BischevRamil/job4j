package ru.job4j.array;

/**
 * Класс объединения двух сортированных массивов, возвращает третий отсортированный массив
 * @author Бишев Рамиль
 * @version 1.0
 * @since 15-08-2019
 */
public class ArraySort {

    /**
     * Метод объединения двух сортированных массивов, возвращает третий отсортированный массив
     * @param left первый сортированный массив
     * @param right второй сортированный массив
     * @return третий сортированный массив, состоящий из двух массивов
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int j = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] < right[i]) {
                System.arraycopy(left, i, result, j++, 1);
                System.arraycopy(right, i, result, j++, 1);
            } else if (left[i] > right[i]) {
                System.arraycopy(right, i, result, j++, 1);
                System.arraycopy(left, i, result, j++, 1);
            }
        }
        return result;
    }
}
