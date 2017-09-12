package com.qunar.fresh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by liyingsong on 16-6-2.
 */
public class DBUtil {
    private static Logger logger = LoggerFactory.getLogger(DBUtil.class);

    private static String DRIVER_NAME = null;
    private static String URL = null;
    private static String USER_NAME = null;
    private static String PWD = null;

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(DBUtil.class.getResourceAsStream("/jdbc.properties"));
        } catch (IOException e) {
            logger.error("error in loading jdbc.properties");
        }
        DRIVER_NAME = properties.getProperty("jdbc.driver");
        URL = properties.getProperty("jdbc.url");
        USER_NAME = properties.getProperty("jdbc.username");
        PWD = properties.getProperty("jdbc.password");
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            logger.error("error in loading driver");
        }
    }

    public static Connection getConnection() {
        // DriverManager.registerDriver(new Driver();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PWD);
        } catch (SQLException e) {
            logger.error("error in creating connection");
        }
        return connection;
    }

    public static void close(Connection connection) {
        close(connection, null, null);
    }

    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                if (!resultSet.isClosed())
                    resultSet.close();
            } catch (SQLException e) {
                logger.error(e.toString());
            }
            try {
                if (!statement.isClosed())
                    statement.close();
            } catch (SQLException e) {
                logger.error(e.toString());
            }
            try {
                if (!connection.isClosed())
                    connection.close();
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
    }
}
