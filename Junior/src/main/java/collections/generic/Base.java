package collections.generic;

/**
 * @author Bischev Ramil
 * @since 2019-11-12
 * @param <T>
 */

public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
