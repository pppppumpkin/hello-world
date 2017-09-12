package com.qunar.fresh.web;

import com.qunar.fresh.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by liyingsong on 16-5-31.
 */
public class LoginServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    public static final int ONE_DAY = 24 * 60 * 60;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("username");
        String pwd = req.getParameter("password");

        if (!LoginService.login(name, pwd)) {
            resp.sendRedirect("/login");
            return;
        }

        Cookie nameCookie = new Cookie("username", URLEncoder.encode(name, "utf-8"));
        Cookie pwdCookie = new Cookie("password", URLEncoder.encode(pwd, "utf-8"));
        nameCookie.setMaxAge(ONE_DAY);
        pwdCookie.setMaxAge(ONE_DAY);
        resp.addCookie(nameCookie);
        resp.addCookie(pwdCookie);

        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
