package com.qunar.fresh.controller;

import com.google.common.base.Objects;
import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import com.qunar.fresh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-6-13.
 */
@Controller
@RequestMapping("/user")
public class UserAddController {
    private static Logger logger = LoggerFactory.getLogger(UserAddController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewAddUser() {
        return "user_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user, Map<String, Object> model) {
        if (Objects.equal(user.getAge(), null) || Objects.equal(user.getName(), null)) {
            return "please_check";
        }
        logger.info("user name = {}", user.getName());
        userService.addUser(user);
        List<User> list = userService.showUserList();
        model.put("users", list);
        return "redirect:list";
    }
}
