package collections.iterator;

/**
 * @author Bischev Ramil
 * @since 2019-11-08
 * 	5.1.2. Создать итератор четные числа[#196565]
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int idx = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
        findEven(values);
    }

    @Override
    public boolean hasNext() {
        return idx != -1;
    }

    @Override
    public Object next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object result = values[idx++];
        findEven(values);
        return result;
    }

    private void findEven(int[] array) {
        boolean even = false;
        for (int i = idx; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                idx = i;
                even = true;
                break;
            }
        }
        if (!even) {
            idx = -1;
        }
    }
}
