package io.io.bot;

import com.google.common.base.Joiner;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ClientTest {
    private static final String LN = System.getProperty("line.separator");


    @Ignore
    @Test
    public void whenAskExitThenClose() throws IOException {
        this.testClient("exit", String.format("exit%s", LN));
    }

    public void testClient(String input, String expected) throws IOException {
        InputStream stdIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(Joiner.on(LN).join(
                "Hello, dear friend, I'm a oracle.",
                "I don't understand...",
                ""
        ).getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.run();
        assertThat(out.toString(), is(expected));
        System.setIn(stdIn);
    }
}
