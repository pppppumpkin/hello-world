package com.qunar.fresh.dao.impl;

import com.qunar.fresh.dao.UserAccountDao;
import com.qunar.fresh.model.UserAccountInfo;
import com.qunar.fresh.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by liyingsong on 16-6-2.
 */
public class UserAccountDaoImpl implements UserAccountDao {
    private static Logger logger = LoggerFactory.getLogger(UserAccountDaoImpl.class);

    @Override
    public UserAccountInfo queryById(Integer id) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserAccountInfo userAccountInfo = null;
        try {
            String sql = "select id, username, password from user_info where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // logger.info("new user");
                userAccountInfo = new UserAccountInfo();
                // logger.info("{}", resultSet.getInt("id"));
                userAccountInfo.setId(resultSet.getInt("id"));
                userAccountInfo.setUsername(resultSet.getString("username"));
                userAccountInfo.setPassword(resultSet.getString("password"));
            }
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return userAccountInfo;
    }

    @Override
    public UserAccountInfo queryByUsername(String username) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserAccountInfo userAccountInfo = null;
        try {
            String sql = "select id, username, password from user_info where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userAccountInfo = new UserAccountInfo();
                // logger.info("{}", resultSet.getInt("id"));
                userAccountInfo.setId(resultSet.getInt("id"));
                userAccountInfo.setUsername(resultSet.getString("username"));
                userAccountInfo.setPassword(resultSet.getString("password"));
            }
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return userAccountInfo;
    }

    @Override
    public int save(UserAccountInfo userAccountInfo) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            String sql = "insert into user_info (username, password) values (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userAccountInfo.getUsername());
            preparedStatement.setString(2, userAccountInfo.getPassword());
            i = preparedStatement.executeUpdate();
        } finally {
            DBUtil.close(connection, preparedStatement);
        }
        return i;
    }

    @Override
    public int update(UserAccountInfo userAccountInfo) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            String sql = "update user_info set password = ? where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userAccountInfo.getPassword());
            preparedStatement.setString(2, userAccountInfo.getUsername());
            i = preparedStatement.executeUpdate();
        } finally {
            DBUtil.close(connection, preparedStatement);
        }
        return i;
    }
}
