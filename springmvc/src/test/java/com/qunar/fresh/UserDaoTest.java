package com.qunar.fresh;

import com.qunar.fresh.dao.UserDao;
import com.qunar.fresh.dao.UserDaoImpl;
import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liyingsong on 16-6-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource
    private UserDao userDao;

    @Test
    public void testShowUsableUsers() {
        logger.info("{}", userDao.showUsableUsers());
    }

    @Test
    public void testQueryByName() {
        logger.info("{}", userDao.queryByName("老王"));
    }

    @Test
    public void testQueryByGroupId() {
        logger.info("{}", userDao.queryByGroupId(1));
    }

    @Test
    public void testSave() {
        User user = UserBuilder.anUserInfo().withName("test").withPassword("test").withSex(12).withAge(0)
                .withGroupId(1).withComment("test").withUsable(true).build();
        userDao.save(user);
        user = UserBuilder.anUserInfo().withName("fred").withPassword("222").withSex(1).withAge(26)
                .withGroupId(1).withComment("fred").withUsable(true).build();
        userDao.save(user);
        user = UserBuilder.anUserInfo().withName("add/delete").withPassword("555").withSex(0).withAge(0)
                .withGroupId(1).withComment("0").withUsable(true).build();
        userDao.save(user);
    }

    @Test
    public void testUpdate() {
        User user = UserBuilder.anUserInfo().withName("update").withPassword("test").withSex(1).withAge(11)
                .withGroupId(1).withComment("update").withUsable(true).withId(1).build();
        userDao.update(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteByName("add/delete");
    }

    @Test
    public void testSetUsable() {
        userDao.setUsable("test");
        Assert.assertTrue(userDao.queryByName("test").get(0).isUsable());
    }

    @Test
    public void testSetUnusable() {
        userDao.setUnusable("test");
        Assert.assertFalse(userDao.queryByName("test").get(0).isUsable());
    }
}
