package com.ulianaafonina.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution (public String returnBook())")
    public Object aroundReturnBookLoggingAdvice (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Logger.info("В библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed();
//        targetMethodResult = "Преступление и наказание"; //так лучше не делать
        long end = System.currentTimeMillis();


        Logger.info("В библиотеку успешно вернули книгу.");
        Logger.info("Метод returnBook() выполнил работу за: " + (end-begin) + " миллисекунд");
        return targetMethodResult;
    }
}
