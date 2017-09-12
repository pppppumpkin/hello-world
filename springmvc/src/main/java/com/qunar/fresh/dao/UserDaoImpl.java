package com.qunar.fresh.dao;

import com.qunar.fresh.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by liyingsong on 16-6-8.
 */
// @Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> showUsableUsers() {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo where usable = true";
        return jdbcTemplate.query(sql, new JdbcUserRowMapper());
    }

    @Override
    public List<User> queryById(int id) {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo where id = ?";
        return jdbcTemplate.query(sql, new Object[] { id }, new JdbcUserRowMapper());
    }

    @Override
    public List<User> queryByName(String name) {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo where name = ?";
        return jdbcTemplate.query(sql, new Object[] { name }, new JdbcUserRowMapper());
    }

    @Override
    public List<User> queryByGroupId(int groupId) {
        String sql = "select id, name, password, sex, age, comment, usable, create_time, last_edit_time, group_id "
                + "from UserInfo where group_id = ?";
        return jdbcTemplate.query(sql, new Object[] { groupId }, new JdbcUserRowMapper());
    }

    @Override
    public int save(User user) {
        String sql = "insert into UserInfo (name, password, sex, age, comment, group_id, last_edit_time) "
                + "values (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[] { user.getName(), user.getPassword(), user.getSex(), user.getAge(),
                user.getComment(), user.getGroupId(), new Timestamp(System.currentTimeMillis()) });
    }

    @Override
    public int update(User user) {
        String sql = "update UserInfo set name = ?, password = ?, sex = ?, age = ?, usable = ?, comment = ?, "
                + "group_id = ?, last_edit_time = ? where id = ?";
        return jdbcTemplate
                .update(sql,
                        new Object[] { user.getName(), user.getPassword(), user.getSex(), user.getAge(),
                                user.isUsable(), user.getComment(), user.getGroupId(),
                                new Timestamp(System.currentTimeMillis()), user.getId() });
    }

    @Override
    public int deleteByName(String name) {
        String sql = "delete from UserInfo where name = ?";
        return jdbcTemplate.update(sql, new Object[] { name });
    }

    @Override
    public int setUnusable(String name) {
        String sql = "update UserInfo set usable = false, last_edit_time = ? where name = ?";
        return jdbcTemplate.update(sql, new Object[] { new Timestamp(System.currentTimeMillis()), name });
    }

    @Override
    public int setUsable(String name) {
        String sql = "update UserInfo set usable = true, last_edit_time = ? where name = ?";
        return jdbcTemplate.update(sql, new Object[] { new Timestamp(System.currentTimeMillis()), name });
    }
}
