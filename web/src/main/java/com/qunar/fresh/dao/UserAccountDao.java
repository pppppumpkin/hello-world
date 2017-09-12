package com.qunar.fresh.dao;

import com.qunar.fresh.model.UserAccountInfo;

import java.sql.SQLException;

/**
 * Created by liyingsong on 16-6-2.
 */
public interface UserAccountDao {
    UserAccountInfo queryById(Integer id) throws SQLException;

    UserAccountInfo queryByUsername(String username) throws SQLException;

    int save(UserAccountInfo userAccountInfo) throws SQLException;

    int update(UserAccountInfo userAccountInfo) throws SQLException;
}
