package multithreading.waitnotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Bischev Ramil
 * @since 2020-06-16
 * Class implements simple bounded blocking queue.
 * @param <T>
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private final int size;

    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    public synchronized void offer(T value) throws InterruptedException {
        while (queue.size() >= this.size) {
            wait();
        }
        queue.add(value);
        notify();
    }

    public synchronized T poll() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T element = queue.poll();
        notify();
        return element;
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}

/**
 * Class Producer puts elements to queue.
 * @param <T>
 */
class Producer<T> implements Runnable {
    private SimpleBlockingQueue<T> queue;
    private List<T> list;

    Producer(SimpleBlockingQueue<T> queue, List<T> list) {
        this.queue = queue;
        this.list = list;
    }

    public void run() {
        for (T t : list) {
            System.out.println("Producer try insert data to queue " + t);
            try {
                queue.offer(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}

/**
 * Class Consumer polls elements from queue.
 * @param <T>
 */
class Consumer<T> implements Runnable {
    private SimpleBlockingQueue<T> queue;
    private List<T> list;

    Consumer(SimpleBlockingQueue<T> queue, List<T> list) {
        this.queue = queue;
        this.list = list;
    }

    public void run() {
        T element;
        while (!queue.isEmpty() || !Thread.currentThread().isInterrupted()) {
            try {
                element = queue.poll();
                System.out.println("Consumer try to poll data " + element);
                list.add(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
    }
}
