package ru.job4j;

import org.junit.Test;
import ru.job4j.diapason.Func;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FuncTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Func.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadroFunctionThenQuadroResults() {
        List<Double> result = Func.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        List<Double> result = Func.diapason(2, 5, x -> Math.floor(Math.log(x) * 1000) / 1000);
        List<Double> expected = Arrays.asList(0.693D, 1.098D, 1.386D);
        assertThat(result, is(expected));
    }
}
