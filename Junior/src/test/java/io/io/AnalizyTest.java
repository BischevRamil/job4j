package io.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void csvTest() {
        List<String> times = List.of(
                "10:58:01; 10:59:01",
                "11:01:02; 11:02:02"
        );
        String source = "./server.log";
        String target = "./unavailable.csv";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        String line;
        int i = 0;
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            while ((line = read.readLine()) != null) {
                assertThat(line, is(times.get(i)));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
