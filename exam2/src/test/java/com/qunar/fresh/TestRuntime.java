package com.qunar.fresh;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by liyingsong on 16-5-27.
 */
public class TestRuntime {
    private static Logger logger = LoggerFactory.getLogger(TestRuntime.class);

    @Test
    public void run() {
        InputStream in = null;
        String command = "cat pom.xml";
        try {
            Process pro = Runtime.getRuntime().exec(command);
            in = pro.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = input.readLine ()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
