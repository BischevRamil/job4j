package io.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author Ramil Bischev
 * @since 2019-12-09
 * Метод сканирует дерево каталогов и возвращает список файлов с заданными расширениями.
 * 2019-12-11 Кооректировка. Программа умеет работать с расширениями и с именами файлов. В качестве параметра
 * можно передать расширение вида *.txt *.doc и т.п. или имя файла без расширения. А так же если передать include==false
 * то вернет все за исключением заданных параметров.
 */
public class Search {
    private  List<File> result = new ArrayList<>();

    public List<File> files(String parent, List<String> exts, boolean include) {
        getByPredicate(parent, s1 -> {
            boolean rsl = false;
            if ((this.checkExt(s1, exts) && include) || (!this.checkExt(s1, exts) && !include)) {
                rsl = true;
            }
            return rsl;
        });
        return result;
    }

    /**
     * Метод возвращает список файлов, которые соответствуют переданному предикату.
     * @param parent Путь до файла или директории.
     * @param predicate Предикат.
     */
    public List<File> getByPredicate(String parent, Predicate<File> predicate) {
        File fileParent = new File(parent);
        Queue<File> fileQueue = new LinkedList<>();
        fileQueue.offer(fileParent);
        File[] deepDirectory = null;
        while (!fileQueue.isEmpty()) {
            File current = fileQueue.poll();
            if (!current.isDirectory()) {
                if (predicate.test(current)) {
                    result.add(current);
                }
            } else {
                deepDirectory = current.listFiles();
                if (deepDirectory != null) {
                    for (File value : deepDirectory) {
                        fileQueue.offer(value);
                    }
                }
            }
        }
        return this.result;
    }

    /**
     * Соответствует ли файл заданному условию.
     * @param file Проверяемый файл.
     * @param exts Условие (Маска или имя файла). Список.
     */
    private boolean checkExt(File file, List<String> exts) {
        boolean rsl = false;
        for (String ext : exts) {
            if (ext.contains("*.")) {
                if (file.getName().endsWith(ext.substring(ext.lastIndexOf('.')))) {
                    rsl = true;
                    break;
                }
            } else {
                if (file.getName().substring(0, file.getName().lastIndexOf('.')).equals(ext)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
}
