package com.qunar.fresh.model;

/**
 * Created by liyingsong on 16-6-1.
 */
public class UserAccess {
    private String username;
    private String page;

    public UserAccess(String username, String page) {
        this.username = username;
        this.page = page;
    }

    public String getUsername() {
        return username;
    }

    public String getPage() {
        return page;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "[username:" + username + ", page:" + page + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserAccess) {
            UserAccess userAccess = (UserAccess) obj;
            return this.username.equals(userAccess.username) && this.page.equals(userAccess.page);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.username + this.page).hashCode();
    }
}
