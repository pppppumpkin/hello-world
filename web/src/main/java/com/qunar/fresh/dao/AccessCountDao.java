package com.qunar.fresh.dao;

import com.qunar.fresh.model.AccessCountInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by liyingsong on 16-6-2.
 */
public interface AccessCountDao {
    public AccessCountInfo queryByUsername(String username) throws SQLException;

    public AccessCountInfo queryByPage(String page) throws SQLException;

    public AccessCountInfo queryByPageAndUsername(String page, String username) throws SQLException;

    public int save(AccessCountInfo accessCountInfo) throws SQLException;

    public int update(AccessCountInfo accessCountInfo) throws SQLException;

    public List<AccessCountInfo> show() throws SQLException;
}
