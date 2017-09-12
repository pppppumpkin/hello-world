package com.qunar.fresh.controller;

import com.qunar.fresh.model.User;
import com.qunar.fresh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-6-13.
 */
@Controller
@RequestMapping("/user")
public class UserDeleteController {
    private static Logger logger = LoggerFactory.getLogger(UserDeleteController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/delete")
    public String deleteUser(String name, Map<String, Object> model) {
        userService.setUserUnusable(name);
        List<User> list = userService.showUserList();
        model.put("users", list);
        return "redirect:list";
    }
}
