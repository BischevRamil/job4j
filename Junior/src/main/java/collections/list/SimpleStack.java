package collections.list;

/**
 * @author Bischev Ramil
 * @since 2019-11-19
 * Реализация стэка на односвязном списке.
 * @param <E>
 */

public class SimpleStack<E> extends SimpleLinkedList {

    public SimpleStack() {
    }

    void push(E value) {
        this.add(value);
    }

    E poll() {
        return (E) this.delete();
    }
}
