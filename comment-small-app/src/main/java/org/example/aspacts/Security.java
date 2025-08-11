package org.example.aspacts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.services.CommentService;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class Security {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Around("@annotation(ToLog)")
    public Object source(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("security check starting!");
        Object res = (Object) joinPoint.proceed();
        logger.info("security checked!");

        return res;
    }
}
