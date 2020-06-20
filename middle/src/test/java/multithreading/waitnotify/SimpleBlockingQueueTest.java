package multithreading.waitnotify;

import multithreading.waitnotify.Consumer;
import multithreading.waitnotify.Producer;
import multithreading.waitnotify.SimpleBlockingQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleBlockingQueueTest {

    @Test
    public void test() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        List<Integer> listIn = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> listOut = new ArrayList<>();
        Producer<Integer> producer = new Producer<>(queue, listIn);
        Consumer<Integer> consumer = new Consumer<>(queue, listOut);
        Thread prod = new Thread(producer);
        prod.start();
        Thread cons = new Thread(consumer);
        cons.start();
        prod.join();
        cons.interrupt();
        cons.join();
        assertThat(listOut, is(listIn));
    }
}
