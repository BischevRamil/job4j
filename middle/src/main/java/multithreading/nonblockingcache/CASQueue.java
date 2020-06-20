package multithreading.nonblockingcache;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Bischev Ramil
 * @since 2020-06-18
 * CASQueue class implements non-blocking queue.
 * @param <T>
 */
@ThreadSafe
public class CASQueue<T> {
    private AtomicReference<Node<T>> head = new AtomicReference<>();
    private AtomicReference<Node<T>> tail = new AtomicReference<>();

    public void push(T value) {
        Node<T> temp = new Node<>(value);
        Node<T> ref;
        do {
            ref = tail.get();
            if (ref == null) {
                head.set(temp);
                tail.set(temp);
                temp.next = null;
                return;
            }
            tail.get().next = temp;
            tail.set(temp);
            temp.next = null;
        } while (!tail.compareAndSet(ref, temp));
    }

    public T poll() {
        Node<T> temp;
        Node<T> ref;
        do {
            ref = head.get();
            if (ref == null) {
                throw new IllegalStateException("Queue is empty");
            }
            temp = ref.next;
        } while (!head.compareAndSet(ref, temp));
        return ref.value;
    }

    private static final class Node<T> {
        final T value;
        Node<T> next;

        public Node(final T value) {
            this.value = value;
        }
    }
}
