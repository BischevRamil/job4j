package collections.list;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynSimpleArrayListTest {
    private DynSimpleArrayList<Integer> arrayList;

    @Before
    public void init() {
        arrayList = new DynSimpleArrayList<>();
    }

    @Test
    public void addNewElementToGrowList() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);

        assertThat(arrayList.get(10), is(11));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getElementFromInvalidIndex() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);
        int a = arrayList.get(11);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorOfDynSimpleArrayWithCheckMod() {
        Iterator<Integer> iterator = arrayList.iterator();
        arrayList.add(103);
        iterator.hasNext();
    }
}
