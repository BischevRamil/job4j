package io.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramil Bischev
 * @since 2019-12-09
 * Метод сканирует дерево каталогов и возвращает список файлов с заданными расширениями.
 * 2019-12-11 Кооректировка. Программа умеет работать с расширениями и с именами файлов. В качестве параметра
 * можно передать расширение вида *.txt *.doc и т.п. или имя файла без расширения. А так же если передать flag==false
 * то вернет все за исключением заданных параметров.
 */
public class Search {
    private  List<File> result = new ArrayList<>();

    public List<File> files(String parent, List<String> exts, boolean flag) {
        File fileParent = new File(parent);
        File[] listFiles = fileParent.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    for (String ext : exts) {
                        if ((flag && checkExt(file, ext)) || (!flag && !checkExt(file, ext))) {
                            result.add(file);
                        }
                    }
                } else {
                    this.files(file.getPath(), exts, flag);
                }
            }
        }
        return result;
    }

    private boolean checkExt(File file, String predict) {
        boolean rsl = false;
        if (predict.contains("*.")) {
            if (file.getName().endsWith(predict.substring(predict.lastIndexOf('.')))) {
                rsl = true;
            }
        } else {
            if (file.getName().substring(0, file.getName().lastIndexOf('.')).equals(predict)) {
                rsl = true;
            }
        }
        return rsl;
    }
}
