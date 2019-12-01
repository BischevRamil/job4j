package collections.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MySimpleTreeTest {

    @Test
    public void when6ElFindLastThen6() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void treeIteratorTest() {
        MySimpleTree<Integer> tree = new MySimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> iterator = tree.iterator();
        assertNotNull(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        assertNotNull(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        assertNotNull(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        assertNotNull(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        assertNotNull(iterator.next());
        assertThat(iterator.hasNext(), is(true));
        assertNotNull(iterator.next());
        assertThat(iterator.hasNext(), is(false));
    }
}
