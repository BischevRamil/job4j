package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

public class ArraySortTest {

    @Test
    public void when10x10Array() {
        int[] left = new int[]{2, 5, 7, 8, 10, 11, 15, 18, 20, 25};
        int[] right = new int[]{1, 3, 8, 9, 11, 12, 14, 17, 18, 26};
        int[] result = ArraySort.merge(left, right);
        Assert.assertArrayEquals(result, new int[]{1, 2, 3, 5, 7, 8, 8, 9, 10, 11, 11, 12, 14, 15, 17, 18, 18, 20, 25, 26});
    }
}
