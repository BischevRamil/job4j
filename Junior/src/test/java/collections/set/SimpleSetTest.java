package collections.set;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    SimpleSet<Integer> simpleSet = new SimpleSet<>();

    @Before
    public void init() {
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
    }

    @Test
    public void setTest() {
        assertThat(simpleSet.size(), is(3));
    }

    @Test
    public void setIteratorTest() {
        Iterator<Integer> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorOfSimpleSetWithCheckMod() {
        Iterator<Integer> iterator = simpleSet.iterator();
        simpleSet.add(4);
        iterator.hasNext();
    }
}
