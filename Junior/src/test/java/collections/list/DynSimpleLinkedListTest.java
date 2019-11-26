package collections.list;

        import org.hamcrest.MatcherAssert;
        import org.junit.Test;
        import org.junit.Before;

        import java.util.ConcurrentModificationException;
        import java.util.Iterator;

        import static org.hamcrest.Matchers.is;
        import static org.junit.Assert.assertThat;

public class DynSimpleLinkedListTest {

    private DynSimpleLinkedList<Integer> list = new DynSimpleLinkedList<>();

    @Test
    public void whenAddThreeElementsThenUseGetTwoResultThree() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.get(2), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetIndexOutOfArrayThenException() {
        list.get(5);
    }


    @Test(expected = ConcurrentModificationException.class)
    public void iteratorOfDynSimpleLinkedListWithCheckMod() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        list.add(103);
        it.hasNext();
    }

    @Test
    public void simpleLinkedListIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        MatcherAssert.assertThat(it.hasNext(), is(true));
        MatcherAssert.assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.next(), is(2));
        MatcherAssert.assertThat(it.next(), is(3));
        MatcherAssert.assertThat(it.hasNext(), is(false));
    }

    @Test
    public void cycleTest() {
        DynSimpleLinkedList.Node first = new DynSimpleLinkedList.Node(1);
        DynSimpleLinkedList.Node second = new DynSimpleLinkedList.Node(2);
        DynSimpleLinkedList.Node third = new DynSimpleLinkedList.Node(3);
        DynSimpleLinkedList.Node fourth = new DynSimpleLinkedList.Node(4);

        list.addNode(first);
        list.addNode(second);
        list.addNode(third);
        list.addNode(fourth);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        assertThat(list.hasCycle(first), is(true));
    }
}
