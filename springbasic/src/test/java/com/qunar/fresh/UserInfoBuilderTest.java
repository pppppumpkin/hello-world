package com.qunar.fresh;

import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyingsong on 16-6-7.
 */
public class UserInfoBuilderTest {
    private static Logger logger = LoggerFactory.getLogger(UserInfoBuilderTest.class);

    @Test
    public void testCreateUser() {
        User user = UserBuilder.anUserInfo().withAge(1).withComment("").withName("user").build();
        logger.info("{}", user);
    }
}
