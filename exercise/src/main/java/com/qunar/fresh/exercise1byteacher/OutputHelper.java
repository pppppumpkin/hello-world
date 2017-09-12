package com.qunar.fresh.exercise1byteacher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by HL on 2016/4/24.
 */
public class OutputHelper {

    private static final String OUTPUT_FILE_PATH = "./exercise/result.txt";

    private static OutputHelper sHelper;

    private OutputHelper() {
    }

    public static OutputHelper getInstance() {
        if (sHelper == null) {
            synchronized (OutputHelper.class) {
                if (sHelper == null) {
                    sHelper = new OutputHelper();
                }
            }
        }
        return sHelper;
    }

    private void writeToFile(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }

        FileWriter fileWriter = null;

        fileWriter = new FileWriter(file);
        fileWriter.write(content);
        if (fileWriter != null) {
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public void output(Map<String, Integer> result) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(sumNumeric(result))
                .append(sumLetter(result))
                .append(parseResultMap(result));
        writeToFile(OUTPUT_FILE_PATH, builder.toString());
    }

    private String sumNumeric(Map<String, Integer> result) {
        Integer sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += result.get("数字" + i);
        }
        return "数字：" + sum + "个" + System.lineSeparator();
    }

    private String sumLetter(Map<String, Integer> result) {
        Integer sum = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            sum += result.get("字母" + c);
        }
        return "字母：" + sum + "个" + System.lineSeparator();
    }

    private String parseResultMap(Map<String, Integer> result) {
        StringBuilder builder = new StringBuilder();
        for (Entry<String, Integer> entry : result.entrySet()) {
            if ("行数".equals(entry.getKey())) {
                builder.append(entry.getKey()).append(": ").append(entry.getValue()).append("行").append(System.lineSeparator());
            } else {
                builder.append(entry.getKey()).append(": ").append(entry.getValue()).append("个").append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

}