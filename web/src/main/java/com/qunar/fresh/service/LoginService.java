package com.qunar.fresh.service;

import com.qunar.fresh.dao.impl.UserAccountDaoImpl;
import com.qunar.fresh.model.UserAccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by liyingsong on 16-6-5.
 */
public class LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    private static UserAccountDaoImpl userAccountDao = new UserAccountDaoImpl();

    public static boolean login(String username, String password) {
        try {
            if (!isUserExists(username)) {
                UserAccountInfo userAccountInfo = new UserAccountInfo(username, password);
                userAccountDao.save(userAccountInfo);
                return true;
            } else {
                return isPasswordRight(username, password);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return false;
    }

    public static boolean isUserExists(String username) {
        try {
            if (userAccountDao.queryByUsername(username) == null) {
                logger.info("new user");
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return false;
    }

    public static boolean isPasswordRight (String username, String password) {
        try {
            if (userAccountDao.queryByUsername(username).getPassword().equals(password)) {
                logger.info("user exists and password is right");
                return true;
            } else {
                logger.info("user exists but password is wrong");
                return false;
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return false;
    }
}
