package io.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchTest {
    @Test
    public void filterFilesTest() throws IOException {
        String tmpdir = System.getProperty("java.io.tmpdir");
        String prefix = "file";
        String suffix1 = ".txt";
        String suffix2 = ".doc";
        File root = new File(tmpdir, "rootDir");
        root.mkdir();
        File dir1 = new File(root, "dir1");
        dir1.mkdir();
        File dir2 = new File(root, "dir2");
        dir2.mkdir();
        File dir3 = new File(dir1, "dir3");
        dir3.mkdir();
        File tempFile1 = File.createTempFile(prefix, suffix1, root);
        File tempFile2 = File.createTempFile(prefix, suffix2, root);
        File tempFile3 = File.createTempFile(prefix, suffix1, dir1);
        File tempFile4 = File.createTempFile(prefix, suffix2, dir1);
        File tempFile5 = File.createTempFile(prefix, suffix1, dir2);
        File tempFile6 = File.createTempFile(prefix, suffix2, dir3);

        List<File> actual = new Search().files(System.getProperty("java.io.tmpdir") + "/rootDir", List.of("txt"), true);
        assertThat(actual.size(), is(3));

    }
}
