package io.io.bot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskEndThenClose() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenAskHelloThenGreatOracul() throws IOException {
        this.testServer(Joiner.on(LN).join("Hello", "exit"),
                Joiner.on(LN).join("Hello, dear friend, I'm a parse-oracle. Please insert next URL: https://www.sql.ru/forum/job-offers and whitespace after.", "", ""));
    }

    @Test
    public void whenAskUnsupportedThenDontUnderstand() throws IOException {
        this.testServer(Joiner.on(LN).join("unsupported ask", "exit"),
                Joiner.on(LN).join("I don't understand", "", ""));
    }


    public void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.run();
        assertThat(out.toString(), is(expected));
    }


}
