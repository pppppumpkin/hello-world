package com.qunar.fresh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by liyingsong on 16-5-18.
 */
public class OutputHelper {
    public static void writeToFile(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        try {
            writer.flush();
        } finally {
            writer.close();
        }
    }
}
