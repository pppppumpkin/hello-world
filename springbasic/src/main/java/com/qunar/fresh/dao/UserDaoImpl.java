package com.qunar.fresh.dao;

import com.qunar.fresh.model.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by liyingsong on 16-6-8.
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public List<User> show() {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo";
        return getJdbcTemplate().query(sql, new JdbcUserRowMapper());
    }

    @Override
    public List<User> queryById(int id) {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo where id = ?";
        return getJdbcTemplate().query(sql, new Object[] { id }, new JdbcUserRowMapper());
    }

    @Override
    public List<User> queryByName(String name) {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo where name = ?";
        return getJdbcTemplate().query(sql, new Object[] { name }, new JdbcUserRowMapper());
    }

    @Override
    public List<User> queryByGroupId(int groupId) {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo where group_id = ?";
        return getJdbcTemplate().query(sql, new Object[] { groupId }, new JdbcUserRowMapper());
    }

    @Override
    public int save(User user) {
        String sql = "insert into UserInfo (name, password, sex, age, comment, usable, group_id, last_edit_time) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
        return getJdbcTemplate()
                .update(sql,
                        new Object[] { user.getName(), user.getPassword(), user.getSex(), user.getAge(),
                                user.getComment(), user.isUsable(), user.getGroupId(),
                                new Timestamp(System.currentTimeMillis()) });
    }

    @Override
    public int update(User user) {
        String sql = "update UserInfo set name = ?, password = ?, sex = ?, age = ?, comment = ?, usable = ?, "
                + "group_id = ?, last_edit_time = ? where id = ?";
        return getJdbcTemplate()
                .update(sql,
                        new Object[] { user.getName(), user.getPassword(), user.getSex(), user.getAge(),
                                user.getComment(), user.isUsable(), user.getGroupId(),
                                new Timestamp(System.currentTimeMillis()), user.getId() });
    }

    @Override
    public int deleteByName(String name) {
        String sql = "delete from UserInfo where name = ?";
        return getJdbcTemplate().update(sql, new Object[] { name });
    }

    @Override
    public int setUnusable(String name) {
        String sql = "update UserInfo set usable = false, last_edit_time = ? where name = ?";
        return getJdbcTemplate().update(sql, new Object[] { new Timestamp(System.currentTimeMillis()), name });
    }
}
