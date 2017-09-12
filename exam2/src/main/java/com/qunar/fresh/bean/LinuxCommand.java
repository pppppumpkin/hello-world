package com.qunar.fresh.bean;

import com.google.common.collect.Lists;
import com.qunar.fresh.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by liyingsong on 16-5-27.
 */
public abstract class LinuxCommand implements Executable<String, List<String>, List<String>> {
    private static Logger logger = LoggerFactory.getLogger(LinuxCommand.class);

//    protected String commandType;
    protected String commandParameter;
    protected String commandPattern;
    protected String fileName = null;
    protected List<String> result = Lists.newArrayList();
    protected List<String> commandSegment;

    public void setCommandParameter(String commandParameter) {
        this.commandParameter = commandParameter;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public abstract boolean judgeCommand(String command);

    public abstract List<String> handle(String command, List<String> tempResult);

    public List<String> execute(String textCommand, List<String> strings) {
        return handle(textCommand, strings);
    }
}
