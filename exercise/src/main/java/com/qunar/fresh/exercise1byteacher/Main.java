package com.qunar.fresh.exercise1byteacher;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liyingsong on 16-5-15.
 */
public class Main {
    //private static Logger logger = Logger.getLogger(Main.class);
    private static String dir = "./exercise/src/main";

    public static void main(String[] args) throws IOException {
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        initResult(result);

        FileIterator fileIterator = new FileIterator(dir);
        while (fileIterator.hasNext()) {
            File currentFile = fileIterator.next();
            //logger.debug("processing file: " + currentFile.getName());
            CharacterIterator characterIterator = new CharacterIterator(currentFile);
            while (characterIterator.hasNext()) {
                updateValue(result, characterIterator.next());
            }
        }

        OutputHelper.getInstance().output(result);
    }

    private static void updateValue(Map<String, Integer> result, String key) {
        if (key != null) {
            Integer integer = result.get(key);
            integer++;
            result.put(key, integer);
        }
    }

    private static void initResult(Map<String, Integer> result) {
        result.put("汉字", 0);
        result.put("空格", 0);
        result.put("行数", 0);
        for (int i = 0; i < 10; i++) {
            result.put("数字" + i, 0);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            result.put("字母" + c, 0);
        }
    }
}
