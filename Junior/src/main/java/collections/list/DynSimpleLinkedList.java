package collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Bischev Ramil
 * @since 2019-11-18
 * Реализация односвязного списка и итератора с fast-fail проверкой.
 * @param <E>
 */
public class DynSimpleLinkedList<E> implements Iterable {
    private int size;
    private int modCount = 0;
    private Node<E> first;

    public DynSimpleLinkedList() {
        this.size = 0;
    }

    /**
     * Метод добавления нового элемента в конец списка
     * @param data
     */
    public void add(E data) {
        this.modCount++;
        this.size++;
        if (this.first == null) {
            this.first = new Node<>(data);
        } else {
            Node<E> tempNode = this.first;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = new Node<>(data);
        }
    }

    public void addNode(Node<E> node) {
        this.modCount++;
        this.size++;
        if (this.first == null) {
            this.first = node;
        } else {
            Node<E> tempNode = this.first;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
    }

    public E get(int index) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод определяет есть ли зацикленность в односвязном списке.
     * @param first
     * @return
     */
    boolean hasCycle(Node<E> first) {
        int count = 0;
        boolean rst = false;
        Node<E> tempNode = first;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            count++;
            if (count > this.size) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private Node<E> current = first;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = current.data;
                current = current.next;
                currentIndex++;
                return result;
            }
        };
    }

    static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
