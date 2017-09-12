package com.qunar.fresh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by liyingsong on 16-6-13.
 */
@Aspect
@Component("recordDaoExecuteTime")
public class RecordDaoExecuteTime {
    private static Logger logger = LoggerFactory.getLogger(RecordDaoExecuteTime.class);

    @Around("execution(* com.qunar.fresh.dao..*.*(..))")
    public Object around(JoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            logger.info("-------- before {} --------", joinPoint.getSignature().getName());
            Object proceed = ((ProceedingJoinPoint) joinPoint).proceed();
            logger.info("-------- after {} --------", joinPoint.getSignature().getName());
            long end = System.currentTimeMillis();
            logger.info("-------- around {}, time = {} ms --------", joinPoint.getSignature().getName(), end - start);
            return proceed;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.info("-------- around {}, time = {} ms with exception --------", joinPoint.getSignature().getName(),
                    end - start);
            logger.error(e.getMessage());
            throw e;
        }
    }
}
