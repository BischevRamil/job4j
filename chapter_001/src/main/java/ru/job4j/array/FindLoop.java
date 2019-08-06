package ru.job4j.array;

/**
 * Поиск элемента в массиве
 * @author Bischev Ramil
 * @since 05-08-2019
 * @version 1.0
 */

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index=0; index<data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index=start; index<=finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        int min = data[0];
        int s = 0;
        for (int i=0; i<data.length; i++){
            min = data[i];
            for (int j=i; j<data.length; j++) {
                if (data[j] < min) min = data[j];
            }
            s = indexOf(data, min, i, data.length-1);
            data[s] = data[i];
            data[i] = min;
        }
        return data;
    }
}
