package collections.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    SimpleStack<Integer> stack = new SimpleStack<>();

    @Test
    public void pushPollTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.getSize(), is(3));
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
