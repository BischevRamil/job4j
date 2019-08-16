package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {

    @Test
    public void testSingleton1() {
        TrackerSingle foo = TrackerSingle.INSTANCE;
        TrackerSingle bar = TrackerSingle.INSTANCE;
        Item first = new Item("test1", "Desc1");
        Item second = new Item("test2", "Desc2");
        foo.tracker.add(first);
        bar.tracker.add(second);
        Item[] items = {first, second};
        Item[] result = bar.tracker.findAll();
        assertThat(items, is(result));
    }

    @Test
    public void testSingletonTwo() {
        TrackerSingleTwo foo = TrackerSingleTwo.getInstance();
        TrackerSingleTwo bar = TrackerSingleTwo.getInstance();
        Item first = new Item("test1", "Desc1");
        Item second = new Item("test2", "Desc2");
        foo.tracker.add(first);
        bar.tracker.add(second);
        Item[] items = {first, second};
        Item[] result = bar.tracker.findAll();
        assertThat(items, is(result));
    }

    @Test
    public void testSingletonThree() {
        TrackerSingleThree foo = TrackerSingleThree.getInstance();
        TrackerSingleThree bar = TrackerSingleThree.getInstance();
        Item first = new Item("test1", "Desc1");
        Item second = new Item("test2", "Desc2");
        foo.tracker.add(first);
        bar.tracker.add(second);
        Item[] items = {first, second};
        Item[] result = bar.tracker.findAll();
        assertThat(items, is(result));
    }

    @Test
    public void testSingletonFour() {
        TrackerSingleFour foo = TrackerSingleFour.getInstance();
        TrackerSingleFour bar = TrackerSingleFour.getInstance();
        Item first = new Item("test1", "Desc1");
        Item second = new Item("test2", "Desc2");
        foo.tracker.add(first);
        bar.tracker.add(second);
        Item[] items = {first, second};
        Item[] result = bar.tracker.findAll();
        assertThat(items, is(result));
    }
}
