package collections.tree;

import java.util.*;

/**
 * @author Bischev Ramil
 * @since 2019-12-01
 * Реализация дерева. Не хранит дубликаты. Итератор реализован с помощью двух стеков.
 * @param <E>
 */
public class MySimpleTree<E extends Comparable> implements SimpleTree<E> {
    private Node<E> root;
    private int size;
    private int modCount;

    public MySimpleTree(E e) {
        this.root = new Node<>(e);
        size++;
    }

    /*
    Метод добавления уникального элемента к существующему родителю.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> findChild = findBy(child);
        if (findChild.isEmpty()) {
            Optional<Node<E>> findParent = findBy(parent);
            if (findParent.isPresent()) {
                Node<E> parentNode = findParent.get();
                parentNode.children.add(new Node<>(child));
                this.size++;
                this.modCount++;
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int currentIndex = 0;
            private Queue<Node<E>> stack1 = new LinkedList<>();
            private Queue<Node<E>> stack2 = new LinkedList<>();

            {
                stack1.offer(root);
                while(!stack1.isEmpty()) {
                    Node<E> el = stack1.poll();
                    stack2.offer(el);
                    for (Node<E> child : el.leaves()) {
                        stack1.offer(child);
                    }
                }
            }

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rsl = Objects.requireNonNull(stack2.poll()).value;
                currentIndex++;
                return rsl;
            }
        };
    }

    static public class Node<E extends Comparable> {
        private final List<Node<E>> children = new ArrayList<>();
        private final E value;

        public Node(final E value) {
            this.value = value;
        }

        public void add(Node<E> child) {
            this.children.add(child);
        }

        public List<Node<E>> leaves() {
            return this.children;
        }

        public boolean eqValue(E that) {
            return this.value.compareTo(that) == 0;


        }
    }
}
