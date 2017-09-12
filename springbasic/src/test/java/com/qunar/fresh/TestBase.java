package com.qunar.fresh;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liyingsong on 16-6-11.
 */
public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);

    private ClassPathXmlApplicationContext context;
    private String xmlPath;

    TestBase() {}

    TestBase(String xmlBase) {
        this.xmlPath = xmlBase;
    }

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext(xmlPath);
        context.start();
    }

    @After
    public void after() {
        context.destroy();
    }

    protected <T extends Object> T getBean(String beanId) {
        return (T)context.getBean(beanId);
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
