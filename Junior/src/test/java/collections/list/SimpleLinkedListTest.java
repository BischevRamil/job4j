package collections.list;

import org.junit.Test;
import org.junit.Before;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    private SimpleLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void deleteFirstElement() {
        assertThat(list.delete(), is(3));
        assertThat(list.getSize(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteNullElementShouldException() {
        list.delete();
        list.delete();
        list.delete();
        list.delete();
    }
}
