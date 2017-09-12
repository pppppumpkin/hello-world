package com.qunar.fresh;

import org.apache.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liyingsong on 16-5-16.
 */
public class ChatParser {
    private static boolean isNewChatRecord = true;
    private static ChatRecord chatRecord;
    private static final Pattern PATTRRN = Pattern
            .compile("^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}) (.*)\\((\\d+)\\)$");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static Logger logger = Logger.getLogger(ChatParser.class);

    public static List<ChatRecord> getChat(File file) {
        List<ChatRecord> list = new ArrayList<ChatRecord>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                Matcher matcher = PATTRRN.matcher(line);
                if (isNewChatRecord && matcher.matches()) {
                    isNewChatRecord = false;
                    chatRecord = new ChatRecord();
                    list.add(chatRecord);
                    chatRecord.setDate(DATE_TIME_FORMATTER.parseLocalDateTime(matcher.group(1)).toDate());
                    chatRecord.setName(matcher.group(2));
                    chatRecord.setId(Integer.parseInt(matcher.group(3)));
                } else if (!line.equals("")) {
                    String message = chatRecord.getMessage();
                    if (null == message)
                        chatRecord.setMessage(line);
                    else
                        chatRecord.setMessage(message + "\n" + line); // 字符串拼接
                } else {
                    isNewChatRecord = true;
                }

            }
        } catch (FileNotFoundException e) {
            logger.error(e.toString());
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return list;
    }

    public static HashMap<Integer, Integer> getChatCount(List<ChatRecord> list) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (ChatRecord cr : list) {
            int id = cr.getId();
            if (map.get(id) == null)
                map.put(id, 1);
            else
                map.put(id, map.get(id) + 1);
        }
        return map;
    }

}
