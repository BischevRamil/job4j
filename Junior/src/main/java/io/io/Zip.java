package io.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Ramil Bischev
 * @since 2019-12-10
 * Класс архивирует каталог вместе со всеми вложенными файлами и каталогами за исключением файлов с расширением $exclude
 */
public class Zip {

    List<File> seekBy(String root, String ext) {
        Search search = new Search();
        List<String> extList = new ArrayList<>(List.of(ext));
        return search.files(root, extList, false);
    }

    public void pack(File source, File target, String ext) {
        List<File> fileList = this.seekBy(source.getPath(), ext);
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : fileList) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        Args arguments = new Args(args);
        File source = new File(arguments.directory());
        File target = new File(arguments.output());
        String exclude = arguments.exclude();
        zip.pack(source, target, exclude);
    }
}
