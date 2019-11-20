package collections.list;

/**
 * @author Bischev Ramil
 * @since 2019-11-20
 * Класс реализует очередь на двух стэках
 * @param <E>
 */

public class SimpleQueue<E> {

    private SimpleStack<E> stackPush = new SimpleStack<E>();
    private SimpleStack<E> stackPoll = new SimpleStack<E>();

    public E poll() {
        if (this.stackPush.getSize() != 0) {
            overflow(stackPush, stackPoll);
        }
        return stackPoll.poll();
    }

    public void push(E value) {
        if (this.stackPoll.getSize() != 0) {
            overflow(stackPoll, stackPush);
        }
        stackPush.push(value);
    }

    private void overflow(SimpleStack<E> from, SimpleStack<E> to) {
        while (from.getSize() != 0) {
            to.push(from.poll());
        }
    }
}