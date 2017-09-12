package com.qunar.fresh.model;

import org.joda.time.DateTime;

// import javax.validation.constraints.Max;
// import javax.validation.constraints.Min;
// import javax.validation.constraints.NotNull;

/**
 * Created by liyingsong on 16-6-7.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private int sex;

    // @NotNull(message = "请输入年龄")
    // @Min(value = 0, message = "这位宝宝你还木有出生呢")
    // @Max(value = 100, message = "请输入正确的年龄")
    private Integer age;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
