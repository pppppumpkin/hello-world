package com.qunar.fresh.web;

import com.qunar.fresh.model.User;
import com.qunar.fresh.model.UserBuilder;
import com.qunar.fresh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liyingsong on 16-6-11.
 */
public class EditUserServlet extends HttpServlet{
    private static Logger logger = LoggerFactory.getLogger(EditUserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        char sex = req.getParameter("sex").charAt(0);
        int age = Integer.parseInt(req.getParameter("age"));
        String comment = req.getParameter("comment");
        String password = req.getParameter("password");
        User user = UserBuilder.anUserInfo().withId(id).withName(name).withPassword(password).withSex(sex).withAge(age)
                .withComment(comment).withUsable(true).withGroupId(1).build();

        ApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
        UserService userService = context.getBean(UserService.class);
        userService.editUser(user);

        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
