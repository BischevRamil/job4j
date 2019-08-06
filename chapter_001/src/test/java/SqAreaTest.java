package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        int p = 18;
        int k = 2;
        int expected = 18;
        int out = SqArea.square(p, k);
        Assert.assertEquals(expected, out);
    }
}
