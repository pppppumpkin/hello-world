package com.qunar.fresh;

import com.qunar.fresh.dao.UserDao;
import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import com.qunar.fresh.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liyingsong on 16-6-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {
        User user = userService.getUserById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void testAddNewUser() {
        User user = UserBuilder.anUserInfo().withName("Jean").withPassword("777").withSex(0).withAge(20)
                .withGroupId(1).withComment("xxx").withUsable(true).build();
        boolean result = userService.addUser(user);
        Assert.assertTrue(result);

    }

    @Test
    public void testAddExistUser() {
        User user = UserBuilder.anUserInfo().withName("Jean").withPassword("777").withSex(0).withAge(20)
                .withGroupId(1).withComment("Jean").withUsable(true).build();
        boolean result = userService.addUser(user);
        Assert.assertFalse(result); //user exists
    }

    @Test
    public void testEditUser() {
        User user = UserBuilder.anUserInfo().withName("testedit").withPassword("testedit").withSex(1).withAge(30)
                .withGroupId(1).withComment("testedit").withUsable(true).withId(1).build();
        boolean result = userService.editUser(user);
        Assert.assertTrue(result);
    }

    @Test
    public void testEditUserWithNameAlreadyInUse() {
        User user = UserBuilder.anUserInfo().withName("fred").withPassword("222").withSex(1).withAge(30)
                .withGroupId(1).withComment("fred").withUsable(true).withId(1).build();
        boolean result = userService.editUser(user);
        Assert.assertFalse(result); //name already in use
    }

    @Test
    public void setUserUnusable() {
        userService.setUserUnusable("fred");
        Assert.assertFalse(userService.getUserByName("fred").isUsable());
    }
}
