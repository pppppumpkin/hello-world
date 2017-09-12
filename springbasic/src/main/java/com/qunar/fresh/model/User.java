package com.qunar.fresh.model;

import org.joda.time.DateTime;

/**
 * Created by liyingsong on 16-6-7.
 */
public class User{
    private int id;
    private String name;
    private String password;
    private char sex;
    private int age;
    private String comment;
    private boolean usable;
    private DateTime createTime;
    private DateTime lastEditTime;
    private int groupId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public DateTime getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(DateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", sex=" + sex
                + ", age=" + age + ", comment='" + comment + '\'' + ", usable=" + usable + ", createTime=" + createTime
                + ", lastEditTime=" + lastEditTime + ", groupId=" + groupId + '}';
    }

}
