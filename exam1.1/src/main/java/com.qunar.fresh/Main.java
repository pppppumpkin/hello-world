package com.qunar.fresh;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liyingsong on 16-5-16.
 * chat.txt修改：
 * 孙辉-dev-创新 最后一条记录昵称改为“孙辉”
 * chat.txt 孙辉-dev-创新 倒数第二条记录昵称改为“孙辉-dev”
 * chat.txt 雪娇-培训 倒数第二条记录昵称修改为“雪娇”
 * result说明：
 * map能够存储多次昵称更改记录，中间改名又改回去的也可以记录在map中
 * chat_sorted中的记录都按最后一个昵称显示
 */
public class Main {
    public static final String inputFilePath = Class.class.getClass().getResource("/").getPath() + "chat.txt";
    //生成到target
    public static final String outputFilePath1 = Class.class.getClass().getResource("/").getPath() + "../../chat_sorted.txt";
    public static final String outputFilePath2 = Class.class.getClass().getResource("/").getPath() + "../../count.txt";
    public static final String outputFilePath3 = Class.class.getClass().getResource("/").getPath() + "../../nickname.txt";
    //生成到target/classes
    //public static final String outputFilePath1 = Class.class.getClass().getResource("/").getPath() + "chat_sorted.txt";
    //public static final String outputFilePath2 = Class.class.getClass().getResource("/").getPath() + "count.txt";
    //生成到resources/tmp
    //public static final String outputFilePath1 = "exam1//src/main//resources//tmp//chat_sout.txt";
    //public static final String outputFilePath2 = "exam1//src//main//resources//tmp//count.txt";
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static Logger logger =Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        File chatFile = new File(inputFilePath);
        ChatParser parser = new ChatParser();
        List<ChatRecord> list = parser.getChat(chatFile);

        ChatRecordComparator crc = new ChatRecordComparator();
        Collections.sort(list, crc);
        //printList(list);

        //countCharRecord(list);

        ChatNickname nickname = new ChatNickname();
        Map<Integer, List<String>> map = nickname.getNickname(list);
        Map<Integer, List<String>> resultMap = sortMap(map);
        printMap(resultMap);
        nickname.changeToLastNickname(list);
        printList(list);

    }

    public static void printList(List<ChatRecord> list) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (ChatRecord cr : list) {
            builder.append("时间：" + df.format(cr.getDate()) + "\n");
            builder.append("昵称：" + cr.getName() + "\n");
            builder.append("号码：" + cr.getId() + "\n");
            builder.append("发言内容：\n" + cr.getText() + "\n");
        }
        String content = builder.toString();
        System.out.println(content);
        writeToFile(outputFilePath1, content);
    }

    private static void writeToFile(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        if (writer != null) {
            writer.flush();
            writer.close();
        }
    }

    public static void printMap(Map<Integer, List<String>> map) throws IOException {
        StringBuilder builder = new StringBuilder();
        Set<Map.Entry<Integer, List<String>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, List<String>> entry : entrySet) {
            builder.append(entry.getKey());
            Iterator<String> iterator = entry.getValue().iterator();
            if (iterator.hasNext())
                builder.append(":" + iterator.next());  //第一个记录前面加":"
            while(iterator.hasNext()) {
                builder.append("," + iterator.next());  //后面的记录前面加","
            }
        builder.append("\n");
        }
        String content = builder.toString();
        System.out.println(content);
        writeToFile(outputFilePath3, content);
    }

    public static Map<Integer, List<String>> sortMap(Map<Integer, List<String>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, List<String>> sortedMap = new TreeMap<Integer, List<String>>(new NicknameMapComparator());
        sortedMap.putAll(map);
        return sortedMap;
    }

//    private static void countCharRecord(List<ChatRecord> list) throws IOException {
//        ChatCount count = new ChatCount();
//        Map<Integer, Integer> map = count.getChatCount(list);
//        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
//        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                if(!o1.getValue().equals(o2.getValue()))
//                    return (o2.getValue() - o1.getValue());
//                else
//                    return (o1.getKey() - o2.getKey());
//            }
//        });
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < entryList.size(); i++) {
//            String entry = entryList.get(i).toString();
//            builder.append(entry + "\n");
//        }
//        String content = builder.toString();
//        System.out.println(content);
//        writeToFile(outputFilePath2, content);
//    }
}
