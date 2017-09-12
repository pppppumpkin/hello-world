package com.qunar.fresh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by liyingsong on 16-6-17.
 */
public class UserLoginService {
    private static Logger logger = LoggerFactory.getLogger(UserLoginService.class);

    private static InputStream inputStream = null;

    public static boolean checkUser(String username, String password) {
        inputStream = UserLoginService.class.getClassLoader().getResourceAsStream("account.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            return (password.equals(properties.getProperty(username)));
        } catch (IOException e) {
            logger.error("load failed, {}", e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error("close failed, {}", e);
            }
        }
        return false;
    }
}
