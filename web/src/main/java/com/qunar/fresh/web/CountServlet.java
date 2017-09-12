package com.qunar.fresh.web;

import com.qunar.fresh.dao.impl.AccessCountDaoImpl;
import com.qunar.fresh.model.AccessCountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyingsong on 16-5-31.
 */
public class CountServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(CountServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        AccessCountDaoImpl accessCountDao = new AccessCountDaoImpl();
        List<AccessCountInfo> list = new ArrayList<AccessCountInfo>();
        try {
            list = accessCountDao.show();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        req.setAttribute("access_count_info_list", list);
        resp.sendRedirect("/count.jsp");
    }
}
