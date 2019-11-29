package collections.set;

import collections.list.DynSimpleArrayList;
import java.util.Iterator;

/**
 * @author Bischev Ramil
 * @since 2019-11-26
 * Реализация коллекции Set на базе динамического массива
 * @param <T>
 */

public class SimpleSet<T> {

    DynSimpleArrayList<T> arrayList = new DynSimpleArrayList<>();

    void add(T data) {
        for (T element : arrayList) {
            if (data == element) {
                return;
            }
        }
        arrayList.add(data);
    }

    int size() {
        return arrayList.size();
    }

    public Iterator<T> iterator() {
        return arrayList.iterator();
    }
}
