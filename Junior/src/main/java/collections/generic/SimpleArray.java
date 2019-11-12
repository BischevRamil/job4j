package collections.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Bischev Ramil
 * @since 2019-11-12
 * @param <T>
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] values;
    private int idx = 0;

    SimpleArray(int size) {
        this.values = (T[]) new Object[size];
    }

    void add(T element) {
        if (idx >= this.values.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.values[idx++] = element;
    }

    T get(int index) {
        if (index >= this.idx) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.values[index];
    }

    boolean set(int index, T model) {
        if (index > this.idx) {
            throw new IllegalArgumentException();
        }
        this.values[index] = model;
        return true;
    }

    boolean remove(int index) {
        if (idx >= this.values.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < this.values.length - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
        idx--;
        return true;
    }

    public int lenght() {
        return this.values.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < idx;
            }

            @Override
            public T next() {
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
