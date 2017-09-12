package com.qunar.fresh.web;

import com.qunar.fresh.model.AccessCountInfo;
import com.qunar.fresh.service.ViewCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by liyingsong on 16-5-31.
 */
public class CountListener implements ServletRequestListener {
    public static Logger logger = LoggerFactory.getLogger(CountListener.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();

        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String name = "tourist";
        String pwd = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                try {
                    if (cookie.getName().equals("username")) {
                        name = URLDecoder.decode(cookie.getValue(), "utf-8");
                    } else if (cookie.getName().equals("password")) {
                        pwd = URLDecoder.decode(cookie.getValue(), "utf-8");
                    }
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.toString());
                }

            }
        }
        String page = req.getServletPath();
        if (!page.contains("login")) {
            AccessCountInfo accessCountInfo = new AccessCountInfo(page, name);
            ViewCounter.increment(accessCountInfo);
        }
    }
}
