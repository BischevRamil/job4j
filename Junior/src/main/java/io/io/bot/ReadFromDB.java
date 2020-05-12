package io.io.bot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReadFromDB implements AutoCloseable {
    private Connection connection;
    private Config config;

    public ReadFromDB(Config config) {
        this.config = config;
    }

    public boolean connectToDB() {
        try {
            Class.forName(config.get("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.get("url"),
                    config.get("username"),
                    config.get("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection != null;
    }

    public List<Post> get(Predicate<Post> filter) {
        List<Post> postList = new ArrayList<>();
        if (connectToDB()) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM vacancies;");
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String text = resultSet.getString("text");
                    String link = resultSet.getString("link");
                    Timestamp date = resultSet.getTimestamp("date");
                    Post post = new Post(name, text, link, date.toLocalDateTime());
                    postList.add(post);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return postList.stream().filter(filter).collect(Collectors.toList());
        }
        return postList;
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }
}
