package collections.generic;

/**
 * @author Bischev Ramil
 * @since 2019-11-12
 * @param <T>
 */

public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
