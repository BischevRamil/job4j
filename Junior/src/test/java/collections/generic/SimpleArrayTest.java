package collections.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    private SimpleArray<Integer> array;

    @Before
    public void init() {
        array = new SimpleArray<>(10);
    }

    @Test
    public void addNewElement() {
        array.add(15);
        assertThat(array.get(0), is(15));
    }

    @Test
    public void setElementOnIndex() {
        array.add(15);
        array.set(0, 10);
        assertThat(array.get(0), is(10));
    }

    @Test
    public void removeElementFromIndex() {
        array.add(15);
        array.add(16);
        array.add(17);
        array.add(18);
        array.add(19);
        array.add(20);
        array.remove(0);
        array.remove(3);
        Integer[] expected = new Integer[10];
        expected[0] = 16;
        expected[1] = 17;
        expected[2] = 18;
        expected[3] = 20;
        assertThat(array.toString(), is(Arrays.toString(expected)));
    }

    @Test
    public void getElementFromIndex() {
        array.add(101);
        array.add(102);
        array.add(103);
        assertThat(array.get(1), is(102));
    }

    @Test
    public void iteratorOfSimpleArray() {
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), is(false));
        array.add(101);
        assertThat(it.hasNext(), is(true));
        array.add(102);
        assertThat(it.next(), is(101));
        assertThat(it.next(), is(102));
        assertThat(it.hasNext(), is(false));
    }
}
