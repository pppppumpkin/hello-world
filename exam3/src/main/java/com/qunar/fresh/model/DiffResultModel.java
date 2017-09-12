package com.qunar.fresh.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by liyingsong on 16-6-17.
 */
public class DiffResultModel {

    private int id;

    /**
     * 用户名
     */
    @NotEmpty
    private String userName;

    /**
     * 对比时间
     */
    @NotEmpty
    private String diffTime;

    /**
     * 源文件
     */
    @NotEmpty
    private String sourceFile;

    /**
     * 目标文件
     */
    @NotEmpty
    private String targetFile;

    /**
     * 对比结果
     */
    @NotEmpty
    private String resultFile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDiffTime() {
        return diffTime;
    }

    public void setDiffTime(String diffTime) {
        this.diffTime = diffTime;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getTargetFile() {
        return targetFile;
    }

    public void setTargetFile(String targetFile) {
        this.targetFile = targetFile;
    }

    public String getResultFile() {
        return resultFile;
    }

    public void setResultFile(String resultFile) {
        this.resultFile = resultFile;
    }

    @Override
    public String toString() {
        return "DiffResultModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", diffTime='" + diffTime + '\'' +
                ", sourceFile='" + sourceFile + '\'' +
                ", targetFile='" + targetFile + '\'' +
                ", resultFile='" + resultFile + '\'' +
                '}';
    }
}
