package com.qunar.fresh;

import com.qunar.fresh.util.DBUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

/**
 * Created by liyingsong on 16-6-2.
 */
public class DBUtilTest {
    private static Logger logger = LoggerFactory.getLogger(DBUtilTest.class);

    @Test
    public void testConnection() {
        Connection connection = DBUtil.getConnection();
        logger.info("{}", connection);
    }
}
