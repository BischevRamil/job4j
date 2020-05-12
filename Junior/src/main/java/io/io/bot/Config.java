package io.io.bot;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("server.properties")) {
            values.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
