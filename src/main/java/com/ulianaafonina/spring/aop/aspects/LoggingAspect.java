package com.ulianaafonina.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution (public void getBook())")
    public void beforeGetBookAdvice () {
        Logger.info("Попытка получить книгу.");
//        System.out.println("Попытка получить книгу.");
    }
}
