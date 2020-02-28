package io.io.bot;

import java.io.*;
import java.net.*;

/**
 * @author Bischev Ramil
 * @since 2019-12-20
 * Клиентская часть бота.
 */
public class Client {

    private Socket socket;

    public Client(String ip, int port) throws IOException {
        this.socket = new Socket(InetAddress.getByName(ip), port);
    }

    public Client(Socket socket) {
        this.socket = socket;
    }

    @SuppressWarnings("checkstyle:Inner assignments should be avoided.")
    public void run() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String request = null;
        String response = null;
        do {
            request = br.readLine();
            out.println(request);
            if (!("exit".equals(request))) {
                while (!(response = in.readLine()).isEmpty()) {
                    System.out.println(response);
                }
            }

        } while (!("exit".equals(request)));
    }


    public static void main(String[] args) throws IOException {
        new Client("localhost", 1111).run();
    }
}