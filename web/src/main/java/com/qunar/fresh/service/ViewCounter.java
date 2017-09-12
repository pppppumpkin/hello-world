package com.qunar.fresh.service;

import com.qunar.fresh.dao.impl.AccessCountDaoImpl;
import com.qunar.fresh.model.AccessCountInfo;
import com.qunar.fresh.model.UserAccess;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyingsong on 16-5-31.
 */
public class ViewCounter {
    private static Map<UserAccess, Integer> userAccessCountMap = new HashMap<UserAccess, Integer>();

    public static void increment(AccessCountInfo accessCountInfo) {
        String page = accessCountInfo.getPage();
        String username = accessCountInfo.getUsername();
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        try {
            AccessCountInfo accessCountInfoFromDB = accessCountDao.queryByPageAndUsername(page, username);
            if (accessCountInfoFromDB == null) {
                accessCountInfo.setCount(1);
                accessCountDao.save(accessCountInfo);
            } else {
                int count = accessCountInfoFromDB.getCount() + 1;
                accessCountInfoFromDB.setCount(count);
                accessCountDao.update(accessCountInfoFromDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Map<UserAccess, Integer> getCount() {
        return userAccessCountMap;
    }
}
