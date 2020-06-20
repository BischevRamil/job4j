package multithreading.nonblockingcache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Bischev Ramil
 * @since 2020-06-20
 * Non blocking cache.
 */
public class NBACache {
    private ConcurrentHashMap<Integer, Base> map = new ConcurrentHashMap<>();

    public void add(Base model) {
        map.putIfAbsent(model.getId(), model);
    }

    public void update(Base model) throws OptimisticException {
        map.computeIfPresent(model.getId(),
                (key, value) -> {
                    int version = model.getVersion();
                    if (version != value.getVersion()) {
                        throw new OptimisticException("Data can't be changed.");
                    }
                    version++;
                    model.setVersion(version);
                    return model;
                }
        );
    }

    public void delete(Base model) {
        this.map.remove(model.getId());
    }
}
