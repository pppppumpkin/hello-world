package com.qunar.fresh;

import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import com.qunar.fresh.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyingsong on 16-6-11.
 */
public class UserServiceTest extends TestBase{
    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    private UserService userService;

    public UserServiceTest() {
        super("userService.xml");
    }

    @Test
    public void testAddUser() {
        userService = super.getBean("myUserService");
        User user = UserBuilder.anUserInfo().withName("fred").withPassword("222").withSex('男').withAge(26)
                .withGroupId(1).withComment("bank").withUsable(true).build();
        boolean result = userService.addUser(user);
//        Assert.assertTrue(result);
        Assert.assertFalse(result);
    }

    @Test
    public void testEditUser() {
        userService = super.getBean("myUserService");
        User user = UserBuilder.anUserInfo().withName("test").withPassword("test").withSex('男').withAge(30)
                .withGroupId(1).withComment("test").withUsable(true).withId(164).build();
        boolean result = userService.editUser(user);
        Assert.assertTrue(result);
    }
}
