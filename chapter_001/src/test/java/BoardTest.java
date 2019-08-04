package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.loop.Board;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void when3x3() {
        Board board = new Board();
        String rsl = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)
                )
        );
    }

    @Test
    public void when8x8() {
        Board board = new Board();
        String rsl = board.paint(8, 8);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X X X %s X X X X%sX X X X %s X X X X%sX X X X %s X X X X%sX X X X %s X X X X%s", ln, ln, ln, ln, ln, ln, ln, ln)
                )
        );
    }
}
