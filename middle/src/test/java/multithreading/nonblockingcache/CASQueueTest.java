package multithreading.nonblockingcache;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
public class CASQueueTest {
    @Test
    public void when1PushThen1Poll() {
        CASQueue<Integer> queue = new CASQueue<>();
        queue.push(1);
        assertThat(queue.poll(), is(1));
    }

    @Test
    public void when2PushThen2Poll() {
        CASQueue<Integer> queue = new CASQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(4));
    }

    @Test
    public void when3PushAndPollByTwoThreadsThen1234() throws InterruptedException {
        CASQueue<Integer> queue = new CASQueue<>();
        List<Integer> result = new ArrayList<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        Thread first = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                result.add(queue.poll());
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                result.add(queue.poll());
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertThat(result, is(expected));
    }

}
