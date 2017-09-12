package com.qunar.fresh.dao;

import com.qunar.fresh.model.User;

import java.util.List;

/**
 * Created by liyingsong on 16-6-7.
 */
public interface UserDao {
    public List<User> show();

    public List<User> queryById(int id);

    public List<User> queryByName(String name);

    public List<User> queryByGroupId(int groupId);

    public int save(User user);

    public int update(User user);

    public int deleteByName(String name);

    public int setUnusable(String name);

}
