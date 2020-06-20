package multithreading.synchronization;

import java.io.*;

public class ParseFile {
    private File file;

    public ParseFile(File file) {
        this.file = file;
    }

    public synchronized File getFile() {
        return this.file;
    }

    public synchronized String getContent(Boolean withoutUnicode) {
        StringBuilder outputWithUnicode = new StringBuilder();
        StringBuilder outputWithoutUnicode = new StringBuilder();
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            int data;
            while ((data = inputStream.read()) != -1) {
                if (withoutUnicode && (data < 0x80)) {
                    outputWithoutUnicode.append((char) data);
                } else {
                    outputWithUnicode.append((char) data);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return withoutUnicode ? outputWithoutUnicode.toString() : outputWithUnicode.toString();
    }

    public synchronized void saveContent(String content) {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < content.length(); i++) {
                outputStream.write(content.charAt(i));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
