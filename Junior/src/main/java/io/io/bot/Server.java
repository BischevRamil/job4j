package io.io.bot;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.List;

import ru.job4j.parser.*;

/**
 * @author Bischev Ramil
 * @since 2019-12-20
 * @version 2.0
 * Server side of bot. If insert URL https://www.sql.ru/forum/job-offers, oracle-bot return list of vacancies from site.
 * Please insert whitespace after URL.
 *
 */
public class Server {
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a parse-oracle. Please insert next URL: https://www.sql.ru/forum/job-offers and whitespace after.");
                out.println();
            } else if (!("exit".equals(ask))) {
                if ("https://www.sql.ru/forum/job-offers ".equals(ask)) {
                    List<Post> vacanciesList = this.getVacancies(ask);
                    for (Post post : vacanciesList) {
                        out.println(post.toString());
                    }
                } else {
                    out.println("I don't understand");
                }
                out.println();
            }
        } while (!("exit".equals(ask)));

    }

    private List<Post> getVacancies(String url) {
        TimeOfLastRun.setDate(LocalDateTime.of(LocalDateTime.now().getYear(), 1, 1, 0, 0));
        Parse parser = new SqlRuParse();
        return parser.list(url);
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(1111).accept()) {
            new Server(socket).run();
        }
    }
}
