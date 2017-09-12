package com.qunar.fresh.service;

import com.google.common.base.Objects;
import com.qunar.fresh.dao.UserDao;
import com.qunar.fresh.dao.UserDaoImpl;
import com.qunar.fresh.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liyingsong on 16-6-10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public List<User> showUserList() {
        return userDao.showUsableUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.queryById(id).get(0);
    }

    @Override
    public User getUserByName(String name) {
        List<User> userList = userDao.queryByName(name);
        if (userList.size() != 0) {
            return userDao.queryByName(name).get(0);
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        if (userDao.queryByName(user.getName()).isEmpty()) {
            userDao.save(user);
            return true;
        } else {
            logger.info("user exists");
            return false;
        }
    }

    @Override
    public boolean deleteUserByName(String name) {
        if (!userDao.queryByName(name).isEmpty()) {
            userDao.deleteByName(name);
//            userDao.setUnusable(name);
            return true;
        } else {
            logger.info("user unusable");
            return false;
        }
    }

    @Override
    public boolean setUserUnusable(String name) {
        if (!userDao.queryByName(name).isEmpty() || userDao.queryByName(name).get(0).isUsable()) {
            userDao.setUnusable(name);
            return true;
        } else {
            logger.info("user unusable");
            return false;
        }
    }

    @Override
    public boolean editUser(User user) {
        if (userDao.queryByName(user.getName()).isEmpty()
                || userDao.queryById(user.getId()).get(0).getName().equals(user.getName())) {
            userDao.update(user);
            return true;
        } else {
            logger.info("name already in use");
            return false;
        }
    }


}
