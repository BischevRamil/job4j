package io.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bischev Ramil
 * @since 2020-01-19
 * Программа поиска файлов в каталоге и подкаталогах.
 * Запускается с параметрами:
 * -d - обязательный параметр. Каталог в котором искать.
 * -n - обязательный параметр. Маска файла или имя файла.
 * -o - обязательный параметр. Название лога, куда будут записаны результаты. Лог-файл появится в temp-папке вашей ОС.
 * -e - необязательный параметр. Флаг, если указан, то искать будет все файлы за исключением указанного после параметра -n.
 * Например  FileSearcher.jar -d c:\ -n *.txt -o log.txt -e найдет все файлы за исключением с расширением txt в директории c:\
 * и запишет результат в файл log.txt.
 */
public class FileSearcher {
    private List<File> result = new ArrayList<>();
    private static final String TF = System.getProperty("java.io.tmpdir");
    private static final String LN = System.getProperty("line.separator");

    public static void main(String[] args) {
        String path = "";
        List<String> exts = new ArrayList<>();
        String log = "";
        boolean include = true;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case ("-d"):
                    path = args[++i];
                    break;
                case ("-n"):
                    String ext = args[++i];
                    exts.add(ext);
                    break;
                case ("-o"):
                    log = args[++i];
                    break;
                case ("-e"):
                    include = false;
                    break;
                default:
                    break;
            }
        }
        if (isValid(args)) {
            FileSearcher fileSearcher = new FileSearcher();
            fileSearcher.run(path, exts, include);
            fileSearcher.writeLog(log);
        } else {
            printHelp();
        }
    }

    /**
     * Валидация ключей.
     * @param args Входящие параметры.
     * @return возвращает true если параметры верны.
     */
    private static boolean isValid(String[] args) {
        int val = 0;
        for (String arg : args) {
            switch (arg) {
                case ("-d"):
                case ("-n"):
                case ("-o"):
                    val++;
                    break;
                default:
                    break;
            }
        }
        return val == 3;
    }

    /**
     * Метод печати помощи.
     */
    private static void printHelp() {
        System.out.println("Подсказка:"
                + LN + "-d - обязательный параметр. Каталог в котором искать."
                + LN + "-n - обязательный параметр. Маска файла или имя файла."
                + LN + "-o - обязательный параметр. Название лога, куда будут записаны результаты. Лог-файл появится в temp-папке вашей ОС."
                + LN + "-e - необязательный параметр. Флаг, если указан, то искать будет все файлы за исключением указанного после параметра -n.");
    }

    /**
     * Метод записи результатов в файл.
     * @param outputFile название файла.
     */
    private void writeLog(String outputFile) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(TF + File.separator + outputFile))) {
            for (File file : this.result) {
                out.println(file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run(String path, List<String> exts, Boolean include) {
        Search fileSearch = new Search();
        result = fileSearch.files(path, exts, include);
        System.out.println(this.result);
    }
}
