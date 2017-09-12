package com.qunar.fresh;

import org.apache.log4j.Logger;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyingsong on 16-5-16.
 */
public class ChatParser {
    private static boolean isNewChatRecord = true;
    private static ChatRecord chatRecord;
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static Logger logger =Logger.getLogger(ChatParser.class);

    public List<ChatRecord> getChat(File file) {
        List<ChatRecord> list = new ArrayList<ChatRecord>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (isNewChatRecord) {
                    isNewChatRecord = false;
                    chatRecord = new ChatRecord();
                    list.add(chatRecord);
                    String[] info = line.split(" ");
                    String date = info[0] + " " + info[1];
                    chatRecord.setDate(df.parse(date));
                    String name = info[2].split("\\(")[0];
                    chatRecord.setName(name);
                    String sid = info[2].split("\\(")[1];
                    chatRecord.setId(Integer.parseInt(sid.substring(0, sid.length() - 1)));
                } else if (!line.equals("")) {
                    chatRecord.setText(line);
                } else {
                    isNewChatRecord = true;
                    //list.add(charRecord);
                }

            }

        } catch (FileNotFoundException e) {
            logger.error(this.getClass().toString() + e.toString());
        } catch (IOException e) {
            logger.error(this.getClass().toString() + e.toString());
        } catch (ParseException e) {
            logger.error(this.getClass().toString() + e.toString());
        }
        return list;
    }

}
