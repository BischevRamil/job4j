package collections.set;

import collections.list.DynSimpleArrayList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Bischev Ramil
 * @since 2019-11-26
 * Реализация коллекции Set на базе динамического массива
 * @param <T>
 */

public class SimpleSet<T> implements Iterable<T> {

    DynSimpleArrayList<T> arrayList = new DynSimpleArrayList<>();
    private int modCount = 0;

    void add(T data) {
        for (T element : arrayList) {
            if (data == element) {
                return;
            }
        }
        modCount++;
        arrayList.add(data);
    }

    int size() {
        return arrayList.size();
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
                return currentIndex < size();
            }

            @Override
            public T next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return arrayList.values[currentIndex++];
            }
        };
    }
}
