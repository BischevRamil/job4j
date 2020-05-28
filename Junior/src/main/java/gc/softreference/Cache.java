package gc.softreference;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Class Cache. Implementing a cache on Soft References links.
 * @author Bischev Ramil
 * @since 2020-05-28
 */
public class Cache {
    private Map<String, SoftReference<String>> globalMap;
    private String path;

    public Cache(String path) {
        this.path = path;
        this.globalMap = new HashMap<>();
    }

    /**
     * This method loads the contents of the file with key name into the map.
     * @param key name of file.
     */
    public void put(String key) {
        SoftReference<String> softValue = null;
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path + key), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        softValue = new SoftReference<>(contentBuilder.toString());
        globalMap.put(key, softValue);
    }

    /**
     * This method retrieves the key value from the map.
     * If there is no such value, then it loads from the file and then gets it.
     * @param key key
     * @return value
     */
    public String getText(String key) {
        if (this.globalMap.get(key) == null) {
            this.put(key);
        }
        return this.globalMap.get(key).get();
    }
}
