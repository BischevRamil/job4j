package collections.map;

import java.util.*;

/**
 * @author Bischev Ramil
 * @since 2019-11-29
 * Реализация HashMap без разрешения коллизий.
 * @param <K>ключ
 * @param <V>значение
 */
public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Node<K, V>[] hashTable;
    private int size;
    private int modCount;
    private float treshold;

    public SimpleHashMap() {
        this.hashTable = new Node[DEFAULT_INITIAL_CAPACITY];
        this.treshold = this.hashTable.length * 0.75f;
    }

    private int hash(K key) {
        int h = 31;
        h = h * 17 + key.hashCode();
        return h;
    }

    private int indexFor(int hash) {
        return hash & hashTable.length - 1;
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    boolean insert(K key, V value) {
        if (this.size + 1 >= this.treshold) {
            this.treshold = this.treshold * 2;
            arrayResize();
        }
        int h = hash(key);
        if (hashTable[indexFor(h)] == null) {
            this.size++;
            this.modCount++;
            Node<K, V> newNode = new Node<K, V>(h, key, value);
            hashTable[indexFor(h)] = newNode;
            return true;
        } else {
            if (this.hashTable[indexFor(h)].getKey().equals(key)) {
                this.hashTable[indexFor(h)].setValue(value);
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void arrayResize() {
        Node<K, V>[] oldTable = this.hashTable;
        this.hashTable = new Node[oldTable.length * 2];
        this.size = 0;
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                insert(node.key, node.value);
            }
        }
    }

    V get(K key) {
        int index = indexFor(hash(key));
        if (this.hashTable[index] != null) {
            return this.hashTable[index].getValue();
        }
        return null;
    }

    boolean delete(K key) {
        int index = indexFor(hash(key));
        if (this.hashTable[index] != null) {
            this.size--;
            this.modCount++;
            this.hashTable[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int currentIndex = 0;

            {
                this.findNext();
            }

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return this.currentIndex != -1 && this.currentIndex < size;
            }

            @Override
            public Node<K, V> next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                Node<K, V> result = hashTable[currentIndex++];
                this.findNext();
                return result;
            }

            private void findNext() {
                boolean result = false;
                for (int i = currentIndex; i < hashTable.length; i++) {
                    if (hashTable[i] != null) {
                        this.currentIndex = i;
                        result = true;
                        break;
                    }
                }
                if (!result) {
                    currentIndex = -1;
                }
            }
        };
    }

    public static class Node<K, V> {
        final int hash;
        private final K key;
        private V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public void setValue(V newValue) {
            this.value = newValue;
        }


        public final String toString() {
            return this.key + "=" + this.value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(this.key);
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            } else {
                if (o instanceof Node) {
                    Node<K, V> node = (Node) o;
                    return (Objects.equals(this.key, node.getKey())
                            && Objects.equals(this.value, node.getValue())
                            || Objects.equals(this.hash, node.hashCode()));
                }
                return false;
            }
        }
    }
}
