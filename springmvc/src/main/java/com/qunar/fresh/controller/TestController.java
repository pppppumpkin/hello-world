package com.qunar.fresh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by liyingsong on 16-6-14.
 */
@Controller("/")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("binding_date.do")
    @ResponseBody
    public String date(Date date) {
        return date.toString();
    }
}
