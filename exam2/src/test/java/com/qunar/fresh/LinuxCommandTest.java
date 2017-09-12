package com.qunar.fresh;

import com.qunar.fresh.bean.Cat;
import com.qunar.fresh.bean.Grep;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by liyingsong on 16-5-31.
 */
public class LinuxCommandTest {
    private static Logger logger = LoggerFactory.getLogger(LinuxCommandTest.class);

//    @Test
//    public void testCat() {
//        Cat cat = new Cat();
//        cat.execute("cat pom.xml", null );
//
//    }

    @Test
    public void testGrep() {
        Grep grep = new Grep();
        grep.execute("grep dependency pom.xml", null);
    }
}
