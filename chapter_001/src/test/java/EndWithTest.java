package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EndWithTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        EndWith word = new EndWith();
        boolean result = word.endsWith("Hello", "lo");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        EndWith word = new EndWith();
        boolean result = word.endsWith("Hello", "la");
        assertThat(result, is(false));
    }
}
