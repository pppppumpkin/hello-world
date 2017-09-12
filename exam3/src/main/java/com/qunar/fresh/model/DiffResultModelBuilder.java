package com.qunar.fresh.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyingsong on 16-6-17.
 */
public final class DiffResultModelBuilder {
    private static Logger logger = LoggerFactory.getLogger(DiffResultModelBuilder.class);
    private int id;
    private String userName;
    private String diffTime;
    private String sourceFile;
    private String targetFile;
    private String resultFile;

    private DiffResultModelBuilder() {
    }

    public static DiffResultModelBuilder aDiffResultModel() {
        return new DiffResultModelBuilder();
    }

    public DiffResultModelBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public DiffResultModelBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public DiffResultModelBuilder withDiffTime(String diffTime) {
        this.diffTime = diffTime;
        return this;
    }

    public DiffResultModelBuilder withSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
        return this;
    }

    public DiffResultModelBuilder withTargetFile(String targetFile) {
        this.targetFile = targetFile;
        return this;
    }

    public DiffResultModelBuilder withResultFile(String resultFile) {
        this.resultFile = resultFile;
        return this;
    }

    public DiffResultModel build() {
        DiffResultModel diffResultModel = new DiffResultModel();
        diffResultModel.setId(id);
        diffResultModel.setUserName(userName);
        diffResultModel.setDiffTime(diffTime);
        diffResultModel.setSourceFile(sourceFile);
        diffResultModel.setTargetFile(targetFile);
        diffResultModel.setResultFile(resultFile);
        return diffResultModel;
    }
}
