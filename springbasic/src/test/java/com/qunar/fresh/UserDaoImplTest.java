package com.qunar.fresh;

import com.qunar.fresh.dao.UserDao;
import com.qunar.fresh.dao.UserDaoImpl;
import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyingsong on 16-6-9.
 */
public class UserDaoImplTest extends TestBase{
    private static Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);

    private UserDao userDao;

    public UserDaoImplTest() {
        super("daoImpl.xml");
    }

    @Test
    public void testShow() {
        userDao = super.getBean(UserDaoImpl.class);
        logger.info("{}", userDao.show());
    }

    @Test
    public void testQueryByName() {
        userDao = super.getBean(UserDaoImpl.class);
        logger.info("{}", userDao.queryByName("老王"));
    }

    @Test
    public void testQueryByGroupId() {
        userDao = super.getBean(UserDaoImpl.class);
        logger.info("{}", userDao.queryByGroupId(1));
    }

    @Test
    public void testSave() {
        userDao = super.getBean(UserDaoImpl.class);
        User user = UserBuilder.anUserInfo().withName("fred").withPassword("222").withSex('男').withAge(26)
                .withGroupId(1).withComment("bank").withUsable(true).build();
        userDao.save(user);
    }

    @Test
    public void testUpdate() {
        userDao = super.getBean(UserDaoImpl.class);
        User user = UserBuilder.anUserInfo().withName("老王").withPassword("666").withSex('男').withAge(30)
                .withGroupId(1).withComment("").withUsable(true).withId(164).build();
        userDao.update(user);
    }

    @Test
    public void testDelete() {
        userDao = super.getBean(UserDaoImpl.class);
        userDao.deleteByName("老王");
    }
}
