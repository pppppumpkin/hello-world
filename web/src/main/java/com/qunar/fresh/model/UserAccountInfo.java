package com.qunar.fresh.model;

/**
 * Created by liyingsong on 16-6-2.
 */
public class UserAccountInfo {
    private int id;
    private String username;
    private String password;

    public UserAccountInfo() {
    }

    public UserAccountInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserAccountInfo{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\''
                + '}';
    }
}
