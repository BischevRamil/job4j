package ru.job4j.flatmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IntToListTest {
    IntToList actual = new IntToList();
    @Test
    public void flatMapTest() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertThat(expected, is(this.actual.convertIntToList(matrix)));
    }
}
