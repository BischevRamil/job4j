package IO.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramil Bischev
 * @since 2019-12-09
 * Метод сканирует дерево каталогов и возвращает список файлов с заданными расширениями.
 */
public class Search {
    private  List<File> result = new ArrayList<>();

    public List<File> files(String parent, List<String> exts) {
        File fileParent = new File(parent);
        File[] listFiles = fileParent.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    for (String ext : exts) {
                        if (file.getName().endsWith(ext)) {
                            result.add(file);
                        }
                    }
                } else {
                    this.files(file.getPath(), exts);
                }
            }
        }
        return result;
    }
}
