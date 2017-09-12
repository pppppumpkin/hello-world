package com.qunar.fresh.model;

/**
 * Created by liyingsong on 16-6-2.
 */
public class AccessCountInfo {
    private int id;
    private String page;
    private int count;
    private String username;

    public AccessCountInfo() {
    }

    public AccessCountInfo(String page, String username) {
        this.page = page;
        this.username = username;
    }

    public AccessCountInfo(String page, String username, int count) {
        this.page = page;
        this.username = username;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AccessCountInfo{" + "id=" + id + ", page='" + page + '\'' + ", count=" + count + ", user_id=" + username
                + '}';
    }
}
