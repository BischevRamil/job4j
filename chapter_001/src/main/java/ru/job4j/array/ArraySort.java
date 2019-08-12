package ru.job4j.array;

import java.util.Arrays;

public class ArraySort {


    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[4];
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

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2, 4};
        int[] result = merge(a, b);
        System.out.println(Arrays.toString(result));
    }
}
