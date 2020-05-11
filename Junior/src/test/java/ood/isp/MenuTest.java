package ood.isp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void beforeTest() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void afterTest() {
        System.setOut(this.stdout);
    }

    @Test
    public void menuTest() {
        Item item1 = new Item("Task 1.");
        Item item11 = new Item("Task 1.1.");
        Item item111 = new Item("Task 1.1.1.");
        Item item112 = new Item("Task 1.1.2.");
        Item item12 = new Item("Task 1.2.");
        Set<Item> items = new TreeSet<>(Set.of(item112, item111, item1, item12, item11));
        Menu menu = new Menu();
        menu.addItems(items);
        menu.show();
        menu.action(item111);
        String expected = new StringJoiner(System.lineSeparator())
                .add("--Task 1.")
                .add("----Task 1.1.")
                .add("------Task 1.1.1.")
                .add("------Task 1.1.2.")
                .add("----Task 1.2.")
                .add("Your choose, Task 1.1.1.")
                .toString();
        assertThat(this.out.toString(), is(expected));
    }
}
