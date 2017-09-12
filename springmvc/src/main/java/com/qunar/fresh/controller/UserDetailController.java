package com.qunar.fresh.controller;

import com.qunar.fresh.model.User;
import com.qunar.fresh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by liyingsong on 16-6-13.
 */
@Controller
@RequestMapping("/user")
public class UserDetailController {
    private static Logger logger = LoggerFactory.getLogger(UserDetailController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String viewUserDetail(@RequestParam("name") String name, Model model) {
        logger.info("In viewUserDetail, name = {}", name);
        User user = userService.getUserByName(name);
        model.addAttribute(user);
        return "user_detail";
    }
}
