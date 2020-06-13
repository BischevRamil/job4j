package collections.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Bischev Ramil
 * @since 2019-11-14
 * Реализация динамического массива.
 * @param <T>
 */
public class DynSimpleArrayList<T> implements Iterable<T> {
    public T[] values;
    private static final int DEFAULT_CAPACITY = 10;
    private int idx = 0;
    private int modCount = 0;

    public DynSimpleArrayList() {
        this.values = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        this.modCount++;
        if (idx == this.values.length) {
            this.values = this.grow();
        }
        this.values[idx++] = element;
    }

    public T get(int index) {
        if (index >= this.idx) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.values[index];
    }

    private T[] grow() {
        return Arrays.copyOf(this.values, this.values.length * 2);
    }

    public int size() {
        return this.idx;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIndex < idx;
            }

            @Override
            public T next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return values[currentIndex++];
            }
        };
    }

    @Override
    public String toString() {
        return Arrays.toString(this.values);
    }
}
