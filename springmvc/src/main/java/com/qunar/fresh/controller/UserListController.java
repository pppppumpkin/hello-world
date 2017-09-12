package com.qunar.fresh.controller;

import com.google.common.base.Objects;
import com.qunar.fresh.model.User;
import com.qunar.fresh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-6-12.
 */
@Controller
@RequestMapping("/user")
public class UserListController {
    private static Logger logger = LoggerFactory.getLogger(UserListController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewUserList(Map<String, Object> model) {
        logger.info("In viewUserList");
        List<User> list = userService.showUserList();
        model.put("users", list);
        return "user_list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String searchUser(String name, Model model) {
        logger.info("In searchUser, name = {}", name);
        User user = userService.getUserByName(name);
        if (Objects.equal(user, null)) {
            return "user_not_found";
        }
        model.addAttribute(user);
        //问题：这里用下面这句redirect无法获取中文名
        //在searchUser方法中有名字，在viewUserDetail中没有
        //直接输入地址http://localhost:8080/user/detail?name=中文，可以查看中文用户信息
        //return "redirect:detail?name=" + name;
        return "user_detail";
    }

}
