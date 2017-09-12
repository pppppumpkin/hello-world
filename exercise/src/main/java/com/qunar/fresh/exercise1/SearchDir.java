package com.qunar.fresh.exercise1;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * old commit
 * Created by liyingsong on 16-5-11.
 */
public class SearchDir {
    private static int[] eng = new int[26];
    private static int[] num = new int[10];
    private static int numCount;
    private static int engCount;
    private static int chiCount;
    private static int spaceCount;
    private static int lineCount;
    private static StringBuffer buffer;
    private static Logger logger =Logger.getLogger(SearchDir.class);

    public static void main(String[] args) throws IOException{
        getCount(new File("exercise//src//main"));
        buffer = new StringBuffer();
        buffer.append("数字："+numCount+"个\n"
                +"字母："+engCount+"个\n"+"汉字："+chiCount+"个\n"
                +"空格："+spaceCount+"个\n"+"行数："+lineCount+"行\n");
        for(int i=0;i<10;i++)
            buffer.append("数字"+i+"："+num[i]+"个\n");
        for(int i=0; i<26; i++) {
            char x = (char)('A'+i);
            buffer.append("字母" + x + "：" + eng[i] + "个\n");
        }
        System.out.println(buffer);
        writeToFile();
    }

    public static void getCount(File file) throws IOException {
        if(file.isFile()) {
            //System.out.println("processing:" + file.getName());
            processFile(file);
        } else if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File subFile : files)
                getCount(subFile);
        }
    }

    public static void processFile(File file) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while(null != (line = reader.readLine())) {
                line = line.toUpperCase();
                lineCount++;
                for(int i=0; i<line.length(); i++) {
                    String temp = String.valueOf(line.charAt(i));
                    if(temp.matches("[0-9]")){
                        numCount++;
                        processNum(temp);
                    }
                    else if(temp.matches("[A-Z]")) {
                        engCount++;
                        processEng(temp);
                    }
                    else if(temp.matches("[\u4e00-\u9fa5]")) {
                        chiCount++;
                    }
                    else if(temp.matches(" "))
                        spaceCount++;
                }
            }
        } catch (FileNotFoundException e) {
            logger.info("file:" + file.getName() + " not found");
        }
    }

    public static void processNum(String word) {
        int temp = Integer.parseInt(word);
        num[temp]++;
    }

    public static void processEng(String word) {
        int temp = word.charAt(0);
        eng[temp-65]++;
    }

    public static void writeToFile() throws IOException{
        File file = new File("exercise/src/main/resources/result.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bw.write(buffer.toString());
        bw.close();
    }

}