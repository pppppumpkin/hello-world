package com.qunar.fresh.web;

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
public class DeleteUserServlet extends HttpServlet{
    private static Logger logger = LoggerFactory.getLogger(DeleteUserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        ApplicationContext context = new ClassPathXmlApplicationContext("userService.xml");
        UserService userService = context.getBean(UserService.class);
        userService.deleteUserByName(name);

        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
