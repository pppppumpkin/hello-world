package com.qunar.fresh.service;

import com.qunar.fresh.dao.UserDaoImpl;
import com.qunar.fresh.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liyingsong on 16-6-10.
 */
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public boolean addUser(User user) {
        ApplicationContext context = new ClassPathXmlApplicationContext("daoImpl.xml");
        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
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
        ApplicationContext context = new ClassPathXmlApplicationContext("daoImpl.xml");
        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
        if (!userDao.queryByName(name).isEmpty()) {
            userDao.deleteByName(name);
            // userDao.setUnusable(name);
            return true;
        } else {
            logger.info("user unusable");
            return false;
        }
    }

    @Override
    public boolean editUser(User user) {
        ApplicationContext context = new ClassPathXmlApplicationContext("daoImpl.xml");
        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
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
