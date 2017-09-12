package com.qunar.fresh;

import org.apache.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liyingsong on 16-5-16.
 */
public class Main {
    public static final String inputFilePath = Class.class.getClass().getResource("/").getPath() + "chat.txt";
    // 生成到项目根目录下
    public static final String outputFilePath1 = Class.class.getClass().getResource("/").getPath()
            + "../../chat_sorted.txt";
    public static final String outputFilePath2 = Class.class.getClass().getResource("/").getPath() + "../../count.txt";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws IOException {
        File chatFile = new File(inputFilePath);
        List<ChatRecord> list = ChatParser.getChat(chatFile);

        ChatRecordComparator crc = new ChatRecordComparator();
        Collections.sort(list, crc);

        printChatRecordList(list);
        printChatRecordCountList(list);
    }

    public static void printChatRecordList(List<ChatRecord> list) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (ChatRecord cr : list) {
            builder.append("时间：" + DATE_TIME_FORMATTER.print(cr.getDate().getTime()) + "\n");
            builder.append("昵称：" + cr.getName() + "\n");
            builder.append("号码：" + cr.getId() + "\n");
            builder.append("发言内容：\n" + cr.getMessage() + "\n");
        }
        String content = builder.toString();
        System.out.println(content);
        OutputHelper.writeToFile(outputFilePath1, content);
    }

    public static void printChatRecordCountList(List<ChatRecord> list) throws IOException {
        Map<Integer, Integer> map = ChatParser.getChatCount(list);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getKey() - o2.getKey());
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < entryList.size(); i++) {
            String entry = entryList.get(i).toString();
            builder.append(entry + "\n");
        }
        String content = builder.toString();
        System.out.println(content);
        OutputHelper.writeToFile(outputFilePath2, content);
    }

}
