package com.qunar.fresh.exercise1;

import java.io.*;
import java.util.LinkedHashMap;

/**
 * new commit
 * Created by liyingsong on 16-5-13.
 */
public class CountCharacter {
    public static final String inputFileDir = "exercise//src//main//resources//com//qunar//fresh";
    //13行报错，资源文件目录下能取文件夹的地址吗？
    //public static final String inputFileDir = CountCharacter.class.getResource("/com.qunar/fresh").getPath();
    //public static final String inputFileDir = CountCharacter.class.getResource("/log4j.properties").getPath();
    public static final String outputFileDir = "result.txt";
    public static CharacterRecord record;
    public static LinkedHashMap<Character, Integer> numRecords;
    public static LinkedHashMap<Character, Integer> engRecords;

    public static void main(String[] args) throws IOException {
        record = new CharacterRecord();
        record.init();
        numRecords = record.getNumRecords();
        engRecords = record.getEngRecords();
        File file = new File(inputFileDir);
        countCharacterInDir(file);
        record.writeToFile(outputFileDir);

    }

    public static void countCharacterInDir(File file) throws IOException {
        if(file.isFile()) {
            //System.out.println("processing:" + file.getName());
            processFile(file);
        } else if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File subFile : files)
                countCharacterInDir(subFile);
        }
    }

    public static void processFile(File file) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while(null != (line = reader.readLine())) {
                line = line.toUpperCase();
                //lineCount++;
                record.setLineCount(record.getLineCount()+1);
                for(int i=0; i<line.length(); i++) {
                    Character temp = line.charAt(i);
                    if(Character.isDigit(temp)){
                        record.setNumCount(record.getNumCount() + 1);
                        processCharacter(temp, "num");
                    }
                    else if(Character.isUpperCase(temp)) {
                        record.setEngCount(record.getEngCount() + 1);
                        processCharacter(temp, "eng");
                    }
                    else if(isChinese(temp)) {
                        record.setChiCount(record.getChiCount() + 1);
                    }
                    else if(' ' == temp)
                        record.setSpaceCount(record.getSpaceCount() + 1);
                }
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
    }

    public static boolean isChinese(char character) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(character);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }

    public static void processCharacter(Character c, String flag) {
        if ("num".equals(flag))
            record.modifyMap(numRecords, c);
        else if ("eng".equals(flag))
            record.modifyMap(engRecords, c);
    }

}
