package gc.softreference;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class Cache. Implementing a cache on Soft References links.
 * @author Bischev Ramil
 * @since 2020-05-28
 */
public class Cache {
    private Map<String, SoftReference<String>> globalMap;
    private String path;
    private static final String LS = System.lineSeparator();

    public Cache(String path) {
        this.path = path;
        this.globalMap = new HashMap<>();
    }

    /**
     * This method loads the contents of the file with key name into the map.
     * @param key name of file.
     */
    public void put(String key) {
        globalMap.put(key, readFile(key));
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

    private SoftReference<String> readFile(String key) {
        String result = "";
        try (Stream<String> stream = Files.lines(Paths.get(path + key), StandardCharsets.UTF_8)) {
            result = stream.collect(Collectors.joining(LS));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SoftReference<>(result);
    }
}
