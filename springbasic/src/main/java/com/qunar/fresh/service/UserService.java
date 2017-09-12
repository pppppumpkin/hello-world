package com.qunar.fresh.service;

import com.qunar.fresh.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liyingsong on 16-6-11.
 */
//@Configuration
public interface UserService {
//    @Bean(name = "muUserService")
//    public UserService myUserService() {
//        return new MyUserService();
//    }

    public boolean addUser(User user);

    public boolean deleteUserByName(String name);

    public boolean editUser(User user);
}
