package com.ulianaafonina.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution (public void get*())")
    public void beforeGetBookAdvice () {
        Logger.info("Попытка получить книгу.");
    }

    @Before("execution (* returnBook())")
    public String beforeReturnBookAdvice () {
        Logger.info("Попытка вернуть книгу.");
        return "OK";
    }

    @Before("execution (* *())")
    public void beforeAnyMethodAdvice () {
        Logger.info("Информационное сообщение");
    }
}
