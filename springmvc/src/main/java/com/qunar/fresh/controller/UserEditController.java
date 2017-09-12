package com.qunar.fresh.controller;

import com.google.common.base.Objects;
import com.qunar.fresh.model.User;
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
public class UserEditController {
    private static Logger logger = LoggerFactory.getLogger(UserEditController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditUser(HttpServletRequest request) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        logger.info("In viewEditUser, id = {}", id);
        User user = userService.getUserById(id);
        request.setAttribute("user", user);
        return "user_edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(User user, Map<String, Object> model) {
        if (Objects.equal(user.getName(), null) || Objects.equal(user.getAge(), null)) {
            return "please_check";
        }
        logger.info("In editUser, name = {}", user.getName());
        if (!userService.editUser(user)) {
            return "username_exists";
        }
        List<User> list = userService.showUserList();
        model.put("users", list);
        return "redirect:list";
    }

}
