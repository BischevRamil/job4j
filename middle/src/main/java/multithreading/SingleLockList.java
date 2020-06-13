package multithreading;

import collections.list.DynSimpleArrayList;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

/**
 * @author Bischev Ramil
 * @since 2020-06-13
 * Thread safe dynamic list.
 * @param <T>
 */
@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this")
    private DynSimpleArrayList<T> list = new DynSimpleArrayList<>();

    public synchronized void add(T value) {
        this.list.add(value);
    }

    public synchronized T get(int index) {
        return this.list.get(index);
    }


    @Override
    public synchronized Iterator<T> iterator() {
        return this.copy(this.list).iterator();
    }

    private DynSimpleArrayList<T> copy(DynSimpleArrayList<T> list) {
        DynSimpleArrayList<T> result = new DynSimpleArrayList<>();
        for (T t : list) {
            result.add(t);
        }
        return result;
    }
}
