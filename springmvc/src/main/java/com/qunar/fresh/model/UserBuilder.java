package com.qunar.fresh.model;

import org.joda.time.DateTime;

/**
 * Created by liyingsong on 16-6-7.
 */
public final class UserBuilder {
    private int id;
    private String name;
    private String password;
    private int sex;
    private Integer age;
    private String comment;
    private boolean usable;
    private DateTime createTime;
    private DateTime lastEditTime;
    private int groupId;

    private UserBuilder() {
    }

    public static UserBuilder anUserInfo() {
        return new UserBuilder();
    }

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withSex(int sex) {
        this.sex = sex;
        return this;
    }

    public UserBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public UserBuilder withUsable(boolean usable) {
        this.usable = usable;
        return this;
    }

    public UserBuilder withCreateTime(DateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public UserBuilder withLastEditTime(DateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
        return this;
    }

    public UserBuilder withGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    public User build() {
        User userInfo = new User();
        userInfo.setId(id);
        userInfo.setName(name);
        userInfo.setPassword(password);
        userInfo.setSex(sex);
        userInfo.setAge(age);
        userInfo.setComment(comment);
        userInfo.setUsable(usable);
        userInfo.setCreateTime(createTime);
        userInfo.setLastEditTime(lastEditTime);
        userInfo.setGroupId(groupId);
        return userInfo;
    }
}
