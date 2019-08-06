package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.loop.Counter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void sum20() {
        Counter counter = new Counter();
        int result = counter.add(0, 20);
        assertThat(result, is(110));
    }
}
