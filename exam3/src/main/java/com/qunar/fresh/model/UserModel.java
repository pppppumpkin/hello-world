package com.qunar.fresh.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by liyingsong on 16-6-17.
 */
public class UserModel {

    /**
     * 用户名
     */
    @NotEmpty
    private String username;

    /**
     * 用户密码
     */
    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
