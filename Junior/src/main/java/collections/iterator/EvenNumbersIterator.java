package collections.iterator;

/**
 * @author Bischev Ramil
 * @since 2019-11-07
 * 	5.1.2. Создать итератор четные числа[#196565]
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int idx = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        int[] evenArray = evenNumbers(values);
        return idx < evenArray.length;
    }

    @Override
    public Object next() {
        int[] evenArray = evenNumbers(values);
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return evenArray[idx++];
    }

    private int[] evenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(a -> a % 2 == 0)
                .toArray();
    }
}
