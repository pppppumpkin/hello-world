package com.qunar.fresh.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liyingsong on 16-6-13.
 */
@Aspect
@Component("getRequestIp")
public class GetRequestIp {
    private static Logger logger = LoggerFactory.getLogger(GetRequestIp.class);

    @Before("execution(* com.qunar.fresh.controller..*.*(..))")
    public void before() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        logger.info("request ip:{}", request.getRemoteAddr());
    }
}
