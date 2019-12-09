package io.io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Stream;

/**
 * @author Bischev Ramil
 * @since 2019-12-08
 * Метод load должен загружать пару ключ-значение в Map values.
 */
public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (Stream<String> stream = Files.lines(Paths.get(this.path))) {
            stream.filter(i -> i.contains("="))
            .forEach(i -> {
                String[] el = i.split("=");
                values.put(el[0], el[1]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("Junior/app.properties"));
    }
}
