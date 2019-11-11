package collections.iterator;

/**
 * @author Bischev Ramil
 * @since 2019-11-11
 * 5.1.1. Итератор для двухмерного массива int[][][#196568]
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int row = 0;
    private int col = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return row < values.length && col < values[row].length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = values[row][col++];
        if (col == values[row].length) {
            col = 0;
            row++;
        }
        return result;
    }
}
