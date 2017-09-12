package com.qunar.fresh;

import java.util.Comparator;

/**
 * Created by liyingsong on 16-5-16.
 */
public class ChatRecordComparator implements Comparator<ChatRecord> {
    public int compare(ChatRecord cr1, ChatRecord cr2) {
        if (cr1.getDate().getTime() < cr2.getDate().getTime())
            return -1;
        else if (cr1.getDate().getTime() > cr2.getDate().getTime())
            return 1;
        else
            return (cr1.getId()-cr2.getId()); //相同时间按id排序
    }
}
