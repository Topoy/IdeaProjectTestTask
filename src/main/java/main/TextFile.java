package main;

import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

    public static void createTextFile(String path, StringBuilder text) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(text.toString());
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
