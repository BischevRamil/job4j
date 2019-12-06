package IO.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bischev Ramil
 * @since 2019-12-06
 * Метод анализирует файл $source и записывает в файл $target время простоя сервера.
 * Сервер не работал. если status = 400 или 500.
 * Формат файла $target "начало периода; конец периода"
 *
 */
public class Analizy {
    private List<String> listTimes = new ArrayList<>();

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            StringBuilder timeStart = new StringBuilder();
            StringBuilder timeEnd = new StringBuilder();
            boolean available = true;
            String line;
            while ((line = read.readLine()) != null) {
                if (!line.isEmpty()) {
                    if (line.charAt(0) == '4' || line.charAt(0) == '5') {
                        if (available) {
                            timeStart.append(line.substring(4));
                            available = false;
                        }
                    } else {
                        if (!available) {
                            timeEnd.append(line.substring(4));
                            available = true;
                        }
                    }
                }
                if (timeStart.length() != 0 && timeEnd.length() != 0) {
                    listTimes.add(String.join("; ", timeStart, timeEnd));
                    timeStart.setLength(0);
                    timeEnd.setLength(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String string : listTimes) {
                out.println(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
