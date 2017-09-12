package com.qunar.fresh;

import com.qunar.fresh.dao.impl.UserAccountDaoImpl;
import com.qunar.fresh.model.UserAccountInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by liyingsong on 16-6-2.
 */
public class UserAccountDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserAccountDaoTest.class);

    @Test
    public void queryById() {
        UserAccountDaoImpl userAccountDao = new UserAccountDaoImpl();
        try {
            UserAccountInfo userAccountInfo = userAccountDao.queryById(1);
            logger.info("{}", userAccountInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryByUsername() {
        UserAccountDaoImpl userAccountDao = new UserAccountDaoImpl();
        try {
            UserAccountInfo userAccountInfo = userAccountDao.queryByUsername("lynn");
//            UserAccountInfo userAccountInfo = userAccountDao.queryByUsername("CCC' or '1' = '1");
            logger.info("{}", userAccountInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void save() {
        UserAccountDaoImpl userAccountDao = new UserAccountDaoImpl();
        UserAccountInfo userAccountInfo = new UserAccountInfo();
        userAccountInfo.setUsername("json");
        userAccountInfo.setPassword("555");
        try {
            int save = userAccountDao.save(userAccountInfo);
            logger.info("{}", save);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Test
    public void update() {
        UserAccountDaoImpl userAccountDao = new UserAccountDaoImpl();
        UserAccountInfo userAccountInfo = new UserAccountInfo();
        userAccountInfo.setUsername("lynn");
        userAccountInfo.setPassword("234");
        try {
            int update = userAccountDao.update(userAccountInfo);
            logger.info("{}", update);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}
