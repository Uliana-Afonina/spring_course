package com.ulianaafonina.spring.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution (* get*())")
    private void allGetMethods() {
    }

    @Before("allGetMethods()")
    public void beforeGetLoggingAdvice() {
        Logger.info("Попытка получить книгу/журнал.");
    }

    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice() {
        Logger.info("Проверка прав на получение книги/журнала.");
    }

//
//    @Before("execution (* returnBook())")
//    public String beforeReturnBookAdvice () {
//        Logger.info("Попытка вернуть книгу.");
//        return "OK";
//    }
//
//    @Before("execution (* *())")
//    public void beforeAnyMethodAdvice () {
//        Logger.info("Информационное сообщение");
//    }
}
