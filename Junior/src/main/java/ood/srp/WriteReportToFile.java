package ood.srp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WriteReportToFile {

    static void write(StringBuilder text, File file) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(file))) {
            out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
