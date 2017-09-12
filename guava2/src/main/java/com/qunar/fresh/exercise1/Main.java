package com.qunar.fresh.exercise1;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by liyingsong on 16-5-23.
 * output -> result.txt
 */
public class Main {
    public static final String accessLogPath = Class.class.getClass().getResource("/").getPath() + "access.log";
    public static final String resultPath = Class.class.getClass().getResource("/").getPath() + "result.txt";

    public static void main(String[] args) throws IOException {

        CountRequestService.processFile(accessLogPath, resultPath);

    }


}
