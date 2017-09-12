package com.qunar.fresh.exercise1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * new commit
 * Created by liyingsong on 16-5-13.
 */
public class CharacterRecord {
    private int numCount;
    private int engCount;
    private int chiCount;
    private int spaceCount;
    private int lineCount;
    private LinkedHashMap<Character, Integer> numRecords;
    private LinkedHashMap<Character, Integer> engRecords;

    public void setNumCount(int numCount) {
        this.numCount = numCount;
    }
    public void setEngCount(int engCount) {
        this.engCount = engCount;
    }
    public void setChiCount(int chiCount) {
        this.chiCount = chiCount;
    }
    public void setSpaceCount(int spaceCount) {
        this.spaceCount = spaceCount;
    }
    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getNumCount() {
        return numCount;
    }
    public int getEngCount() {
        return engCount;
    }
    public int getChiCount() {
        return chiCount;
    }
    public int getSpaceCount() {
        return spaceCount;
    }
    public int getLineCount() {
        return lineCount;
    }
    public LinkedHashMap<Character, Integer> getNumRecords() {
        return numRecords;
    }
    public LinkedHashMap<Character, Integer> getEngRecords() {
        return engRecords;
    }

    public void modifyMap(LinkedHashMap<Character, Integer> map, Character c) {
        if(map.containsKey(c))
            map.put(c, map.get(c)+1);
    }

    public void init() {
        setNumCount(0);
        setEngCount(0);
        setChiCount(0);
        setSpaceCount(0);
        setLineCount(0);
        numRecords = new LinkedHashMap<Character, Integer>();
        for(int i=0; i<10; i++) {
            numRecords.put((char)('0'+i), 0);
        }
        engRecords = new LinkedHashMap<Character, Integer>();
        for(int i=0; i<26; i++) {
            engRecords.put((char)('A'+i), 0);
        }
    }

    public void writeToFile(String fileDir) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("数字："+numCount+"个\n"
                +"字母："+engCount+"个\n"+"汉字："+chiCount+"个\n"
                +"空格："+spaceCount+"个\n"+"行数："+lineCount+"行\n");
        for(int i=0; i<10; i++)
            buffer.append("数字"+i+"："+numRecords.get((char)('0'+i))+"个\n");
        for(int i=0; i<26; i++) {
            char x = (char)('A'+i);
            buffer.append("字母" + x + "：" + engRecords.get((char)('A'+i)) + "个\n");
        }
        File file = new File(fileDir);
        if(!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        bw.write(buffer.toString());
        bw.close();
    }
}
