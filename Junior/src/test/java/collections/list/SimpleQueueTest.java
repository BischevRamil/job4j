package collections.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue = new SimpleQueue<>();

    @Test
    public void queueTest() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
}
