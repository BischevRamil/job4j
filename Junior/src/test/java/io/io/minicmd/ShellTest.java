package io.io.minicmd;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ShellTest {

    @Test
    public void shellTest() {
        final Shell shell = new Shell();
        assertThat(shell.path(), is("/"));

        shell.cd("/");
        assertThat(shell.path(), is("/"));

        shell.cd("usr/..");
        assertThat(shell.path(), is("/"));

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assertThat(shell.path(), is("/usr/local"));

        shell.cd("..");
        assertThat(shell.path(), is("/usr"));

        shell.cd("//lib///");
        assertThat(shell.path(), is("/lib"));
    }
}
