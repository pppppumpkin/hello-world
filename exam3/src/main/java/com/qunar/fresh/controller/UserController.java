package com.qunar.fresh.controller;

import com.google.common.base.Objects;
import com.qunar.fresh.model.UserModel;
import com.qunar.fresh.service.UserLoginService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

/**
 * Created by liyingsong on 16-6-17.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    public static final int ONE_DAY = 24 * 60 * 60;

    @Resource
    private HttpSession httpSession;

    @Resource
    private Properties account;

    @RequestMapping(value = "/login")
    public String loginHandler(String username, String password, HttpServletResponse response) {
        logger.info("username = {}, password = {}", username, password);
        if (!Objects.equal(username, null) &&
                Objects.equal(account.getProperty(username), password)){
            Cookie nameCookie = new Cookie("username", username);
            nameCookie.setMaxAge(ONE_DAY);
            nameCookie.setPath("/");
            response.addCookie(nameCookie);
//            httpSession.setAttribute("username", username);   //do not use session
            return "redirect:/file/diff?page=1";    //how to remember page index before login?
        } else {
            return "login";
        }
    }


}
