package multithreading;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Bischev Ramil
 * @since 2020-06-10
 * Download file with speed limit.
 * Limit on bytes.
 */
public class Wget {
    public static void main(String[] args) {
        String file = args[0];
        int speed = Integer.parseInt(args[1]);
        new Wget().download(file, speed);
    }

    private void download(String file, int speed) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_temp.xml")) {
            byte[] dataBuffer = new byte[speed];
            int bytesRead;
            long startDownload = System.currentTimeMillis();
            int downloaded = 0;
            long startForOutput = startDownload;
            long endForOutput = 0;
            while ((bytesRead = in.read(dataBuffer, 0, speed)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                long timeOfDownload = System.currentTimeMillis();
                endForOutput = timeOfDownload;
                downloaded += bytesRead;
                if (timeOfDownload - startDownload < 1000) {
                    try {
                        Thread.sleep(1000 - (timeOfDownload - startDownload));
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                startDownload = System.currentTimeMillis();
            }
            System.out.format("Скачано %d байт за %d секунд", downloaded, (endForOutput - startForOutput) / 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
