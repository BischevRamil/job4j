package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(7, 4, 2);
        assertThat(result, is(7));
    }

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 6);
        assertThat(result, is(6));
    }

    @Test
    public void whenEquals() {
        MultiMax check = new MultiMax();
        int result = check.max(3, 3, 3);
        assertThat(result, is(3));
    }
}
