package collections.list;

/**
 * @author Bischev Ramil
 * @since 2019-11-19
 * Реализация стэка на односвязном списке.
 * @param <E>
 */

public class SimpleStack<E> {
    private SimpleLinkedList<E> list;

    public SimpleStack() {
        this.list = new SimpleLinkedList<>();
    }

    void push(E value) {
        this.list.add(value);
    }

    E poll() {
        return (E) this.list.delete();
    }

    int getSize() {
        return this.list.getSize();
    }
}
