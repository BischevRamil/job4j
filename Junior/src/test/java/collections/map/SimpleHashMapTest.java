package collections.map;
import org.junit.Test;

import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleHashMapTest {
    private SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();

    @Test
    public void addRecordToMapTest() {
        hashMap.insert(1, "one");
        hashMap.insert(2, "two");
        hashMap.insert(3, "three");
        assertThat(hashMap.size(), is(3));
    }

    @Test
    public void whenAddEqualKeyThenAddNewValue() {
        hashMap.insert(1, "one");
        hashMap.insert(1, "two");
        assertThat(hashMap.get(1), is("two"));
    }

    @Test
    public void deleteRecordTest() {
        hashMap.insert(1, "one");
        assertThat(hashMap.isEmpty(), is(false));
        assertThat(hashMap.size(), is(1));
        assertThat(hashMap.delete(1), is(true));
        assertThat(hashMap.isEmpty(), is(true));
        assertThat(hashMap.size(), is(0));
    }

    @Test
    public void iteratorTest() {
        hashMap.insert(1, "one");
        hashMap.insert(2, "two");
        Iterator<SimpleHashMap.Node<Integer, String>> iterator = this.hashMap.iterator();
        assertThat(hashMap.iterator().hasNext(), is(true));
        SimpleHashMap.Node<Integer, String> node = iterator.next();
        assertThat(node.getKey(), is(1));
        assertThat(node.getValue(), is("one"));
        assertThat(iterator.hasNext(), is(true));
        node = iterator.next();
        assertThat(node.getKey(), is(2));
        assertThat(node.getValue(), is("two"));
        assertThat(iterator.hasNext(), is(false));

    }
}
