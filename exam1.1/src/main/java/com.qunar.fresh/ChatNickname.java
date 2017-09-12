package com.qunar.fresh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liyingsong on 16-5-16.
 */
public class ChatNickname {
    public List<ChatRecord> changeToLastNickname(List<ChatRecord> list) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (ChatRecord cr : list) {
            map.put(cr.getId(), cr.getName());
        }
        for (ChatRecord cr : list) {
            cr.setName(map.get(cr.getId()));
        }
        return list;
    }

    public HashMap<Integer, List<String>> getNickname(List<ChatRecord> list) {
        HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for(ChatRecord cr : list) {
            int id = cr.getId();
            String name = cr.getName();
            if (null == map.get(id)) {
                List<String> nameList = new ArrayList<String>();
                nameList.add(name);
                map.put(id, nameList);
            } else {
                List<String> nameList = map.get(id);
                if (!name.equals(nameList.get(nameList.size()-1))) {
                    nameList.add(name);
                    map.put(id, nameList);
                }
            }
        }
        return map;
    }
}
