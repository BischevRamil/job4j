package ru.job4j.department;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortDeptTest {
    private SortDept sortDept = new SortDept();
    private List<Dept> list = new ArrayList<>();
    private Dept d0 = new Dept("K1");
    private Dept d1 = new Dept("K1\\SK1");
    private Dept d2 = new Dept("K1\\SK2");
    private Dept d3 = new Dept("K1\\SK1\\SSK1");
    private Dept d4 = new Dept("K1\\SK1\\SSK2");
    private Dept d5 = new Dept("K2");
    private Dept d6 = new Dept("K2\\SK1");
    private Dept d7 = new Dept("K2\\SK1\\SSK1");
    private Dept d8 = new Dept("K2\\SK1\\SSK2");

    @Before
    public void init() {
        list.add(d0);
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        list.add(d6);
        list.add(d7);
        list.add(d8);
    }

    @Test
    public void sortAscendingTest() {
       List<Dept> expected = new ArrayList<>();
       expected.add(d0); // K1
       expected.add(d1); // K1\SK1
       expected.add(d3); // K1\SK1\SSK1
       expected.add(d4); // K1\SK1\SSK2
       expected.add(d2); // K1\SK2
       expected.add(d5); // K2
       expected.add(d6); // K2\SK1
       expected.add(d7); // K2\SK1\SSK1
       expected.add(d8); // K2\SK1\SSK2
       assertThat(expected, is(sortDept.sortAscending(list)));
    }

    @Test
    public void sortDescendingTest() {
        List<Dept> expected = new ArrayList<>();
        expected.add(d5); // K2
        expected.add(d6); // K2\SK1
        expected.add(d8); // K2\SK1\SSK2
        expected.add(d7); // K2\SK1\SSK1
        expected.add(d0); // K1
        expected.add(d2); // K1\SK2
        expected.add(d1); // K1\SK1
        expected.add(d4); // K1\SK1\SSK2
        expected.add(d3); // K1\SK1\SSK1
        assertThat(expected, is(sortDept.sortDescending(list)));
    }
}
