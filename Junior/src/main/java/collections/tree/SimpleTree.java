package collections.tree;
import java.util.Optional;

public interface SimpleTree<E extends Comparable> extends Iterable<E> {

    boolean add(E parent, E child);
    Optional<MySimpleTree.Node<E>> findBy(E value);
}
