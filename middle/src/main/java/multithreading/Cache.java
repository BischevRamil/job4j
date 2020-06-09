package multithreading;

public class Cache {
    private static Cache cache;

    private synchronized static Cache instOf() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}
