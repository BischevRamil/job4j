package collections.iterator;

/**
 * @since 2019-11-07
 * @author Bischev Ramil
 * 5.1.4. Создать convert(Iterator<Iterator>)[#196566]
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> inner = it.next();

            @Override
            public boolean hasNext() {
                while (!inner.hasNext() && it.hasNext()) {
                    inner = it.next();
                }
                return inner.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return inner.next();
            }
        };
    }
}
