package com.qunar.fresh.dao.impl;

import com.qunar.fresh.dao.AccessCountDao;
import com.qunar.fresh.model.AccessCountInfo;
import com.qunar.fresh.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyingsong on 16-6-2.
 */
public class AccessCountDaoImpl implements AccessCountDao {
    private static Logger logger = LoggerFactory.getLogger(AccessCountDaoImpl.class);

    @Override
    public AccessCountInfo queryByUsername(String username) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AccessCountInfo accessCountInfo = null;
        try {
            String sql = "select id, page, count, username from access_count where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                accessCountInfo = new AccessCountInfo();
                accessCountInfo.setId(resultSet.getInt("id"));
                accessCountInfo.setPage(resultSet.getString("page"));
                accessCountInfo.setCount(resultSet.getInt("count"));
                accessCountInfo.setUsername(resultSet.getString("username"));
            }
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return accessCountInfo;
    }

    @Override
    public AccessCountInfo queryByPage(String page) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AccessCountInfo accessCountInfo = null;
        try {
            String sql = "select id, page, count, username from access_count where page = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, page);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                accessCountInfo = new AccessCountInfo();
                accessCountInfo.setId(resultSet.getInt("id"));
                accessCountInfo.setPage(resultSet.getString("page"));
                accessCountInfo.setCount(resultSet.getInt("count"));
                accessCountInfo.setUsername(resultSet.getString("username"));
            }
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return accessCountInfo;
    }

    @Override
    public AccessCountInfo queryByPageAndUsername(String page, String username) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AccessCountInfo accessCountInfo = null;
        try {
            String sql = "select id, page, count, username from access_count where page = ? and username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, page);
            preparedStatement.setString(2, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                accessCountInfo = new AccessCountInfo();
                accessCountInfo.setId(resultSet.getInt("id"));
                accessCountInfo.setPage(resultSet.getString("page"));
                accessCountInfo.setCount(resultSet.getInt("count"));
                accessCountInfo.setUsername(resultSet.getString("username"));
            }
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return accessCountInfo;
    }

    @Override
    public int save(AccessCountInfo accessCountInfo) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            String sql = "insert into access_count (page, count, username) values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accessCountInfo.getPage());
            preparedStatement.setInt(2, accessCountInfo.getCount());
            preparedStatement.setString(3, accessCountInfo.getUsername());
            i = preparedStatement.executeUpdate();
        } finally {
            DBUtil.close(connection, preparedStatement);
        }
        return i;
    }

    @Override
    public int update(AccessCountInfo accessCountInfo) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            String sql = "update access_count set count = ? where page = ? and username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accessCountInfo.getCount());
            preparedStatement.setString(2, accessCountInfo.getPage());
            preparedStatement.setString(3, accessCountInfo.getUsername());
            i = preparedStatement.executeUpdate();
        } finally {
            DBUtil.close(connection, preparedStatement);
        }
        return i;
    }

    @Override
    public List<AccessCountInfo> show() throws SQLException {
        Connection connection = DBUtil.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<AccessCountInfo> list = new ArrayList<AccessCountInfo>();
        try {
            String sql = "select id, page, count, username from access_count";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                AccessCountInfo accessCountInfo = new AccessCountInfo();
                accessCountInfo.setId(resultSet.getInt("id"));
                accessCountInfo.setPage(resultSet.getString("page"));
                accessCountInfo.setCount(resultSet.getInt("count"));
                accessCountInfo.setUsername(resultSet.getString("username"));
                list.add(accessCountInfo);
            }
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return list;
    }
}
