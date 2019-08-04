package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.loop.Factorial;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void fact5() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void fact0() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(0));
    }
}
