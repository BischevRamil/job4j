package collections.iterator;

/**
 * @author Bischev Ramil
 * @since 2019-11-07
 * 5.1.1. Итератор для двухмерного массива int[][][#196568]
 */

import java.util.Iterator;

public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int idx = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        int foo = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                foo++;
            }
        }
        return idx < foo;
    }

    @Override
    public Object next() {
        int foo = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (foo == idx) {
                    idx++;
                    return values[i][j];
                }
                foo++;
            }
        }
        return null;
    }
}
