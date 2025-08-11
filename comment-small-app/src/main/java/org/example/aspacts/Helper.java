package org.example.aspacts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.services.CommentService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(2)
public class Helper {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

//    @Around("execution(* org.example.services.*.*(..))")
    @Around("@annotation(ToLog)")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method " + methodName + " will execute");
        joinPoint.proceed();
        logger.info("Method " + methodName + " executed");
    }
}
