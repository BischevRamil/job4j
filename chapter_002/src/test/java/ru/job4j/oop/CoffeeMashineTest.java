package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMashineTest {
    @Test
    public void in100cost62coffee() {
        int[] rst = CoffeeMashine.changes(100, 62);
        assertThat(rst, is(new int[]{10, 10, 10, 5, 2, 1}));
    }
}
