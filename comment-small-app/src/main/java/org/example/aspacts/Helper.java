package org.example.aspacts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.services.CommentService;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
public class Helper {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Around("execution(* org.example.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute");
        joinPoint.proceed();
        logger.info("Method executed");
    }
}
