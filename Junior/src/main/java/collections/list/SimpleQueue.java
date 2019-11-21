package collections.list;

/**
 * @author Bischev Ramil
 * @since 2019-11-20
 * Класс реализует очередь на двух стэках
 * @param <E>
 */

public class SimpleQueue<E> {

    private SimpleStack<E> first = new SimpleStack<>();
    private SimpleStack<E> second = new SimpleStack<>();

    public E poll() {
        if (this.second.getSize() == 0) {
            while (this.first.getSize() != 0) {
                this.second.push(this.first.poll());
            }
        }
        return this.second.poll();
    }

    public void push(E value) {
        this.first.push(value);
    }
}