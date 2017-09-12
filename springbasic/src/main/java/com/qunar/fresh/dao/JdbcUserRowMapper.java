package com.qunar.fresh.dao;

import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liyingsong on 16-6-8.
 */
public class JdbcUserRowMapper implements RowMapper<User> {
    private static Logger logger = LoggerFactory.getLogger(JdbcUserRowMapper.class);

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = UserBuilder.anUserInfo().withId(resultSet.getInt("id")).withName(resultSet.getString("name"))
                .withPassword(resultSet.getString("password")).withSex(resultSet.getString("sex").charAt(0))
                .withAge(resultSet.getInt("age")).withComment(resultSet.getString("comment"))
                .withCreateTime(FORMATTER.parseDateTime(resultSet.getTimestamp("create_time").toString()))
                .withLastEditTime(FORMATTER.parseDateTime(resultSet.getTimestamp("last_edit_time").toString()))
                .withUsable(resultSet.getBoolean("usable")).withGroupId(resultSet.getInt("group_id")).build();
        return user;
    }
}
