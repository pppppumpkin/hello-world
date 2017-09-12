package com.qunar.fresh;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liyingsong on 16-5-16.
 */
public class ChatCount {

    public HashMap<Integer, Integer> getChatCount (List<ChatRecord> list) {
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
