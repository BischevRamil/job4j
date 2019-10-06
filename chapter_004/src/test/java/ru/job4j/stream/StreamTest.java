package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StreamTest {
    @Test
    public void sumOfElementsTest() {
        Stream stream = new Stream();
        var array = new ArrayList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        var expected = 120;
        assertThat(expected, is(stream.streamAPI(array)));
    }
}
