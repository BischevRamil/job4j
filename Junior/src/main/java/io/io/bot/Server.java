package io.io.bot;

import java.io.*;
import java.net.*;

/**
 * @author Bischev Ramil
 * @since 2019-12-20
 * Серверная часть бота
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
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (!("exit".equals(ask))) {
                out.println("I don't understand...");
                out.println();
            }
        } while (!("exit".equals(ask)));

    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(1111).accept()) {
            new Server(socket).run();
        }
    }
}
