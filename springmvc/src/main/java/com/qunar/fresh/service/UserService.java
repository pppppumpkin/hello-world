package com.qunar.fresh.service;

import com.qunar.fresh.model.User;

import java.util.List;

/**
 * Created by liyingsong on 16-6-11.
 */
public interface UserService {

    public List<User> showUserList();

    public User getUserById(int id);

    public User getUserByName(String name);

    public boolean addUser(User user);

    public boolean deleteUserByName(String name);

    public boolean setUserUnusable(String name);

    public boolean editUser(User user);
}
