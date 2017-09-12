package com.qunar.fresh;

import com.qunar.fresh.dao.impl.AccessCountDaoImpl;
import com.qunar.fresh.model.AccessCountInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by liyingsong on 16-6-2.
 */
public class AccessCountDaoTest {
    private static Logger logger = LoggerFactory.getLogger(AccessCountDaoTest.class);

    @Test
    public void queryByPageAndUsername() {
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        try {
            AccessCountInfo accessCountInfo = accessCountDao.queryByPageAndUsername("/index.jsp", "lynn");
            logger.info("{}", accessCountInfo);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Test
    public void queryByPage() {
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        try {
            AccessCountInfo accessCountInfo = accessCountDao.queryByPage("/index.jsp");
            logger.info("{}", accessCountInfo);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Test
    public void save() {
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        AccessCountInfo accessCountInfo = new AccessCountInfo();
        accessCountInfo.setPage("/index.jsp");
        accessCountInfo.setCount(1);
        accessCountInfo.setUsername("lynn");
        try {
            int save = accessCountDao.save(accessCountInfo);
            logger.info("{}", save);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Test
    public void update() {
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        AccessCountInfo accessCountInfo = new AccessCountInfo();
        accessCountInfo.setPage("/index.jsp");
        accessCountInfo.setCount(2);
        accessCountInfo.setUsername("lynn");
        try {
            int update = accessCountDao.update(accessCountInfo);
            logger.info("{}", update);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Test
    public void show() {
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        try {
            List<AccessCountInfo> list = accessCountDao.show();
            logger.info("{}", list);
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}
