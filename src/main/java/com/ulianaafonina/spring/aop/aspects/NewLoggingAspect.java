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
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Logger.info("В библиотеку пытаются вернуть книгу");
        Object targetMethodResult;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();

        } catch (ArithmeticException e) {
            Logger.error(e, "Ошибочка вышла");
            targetMethodResult = "Неизвестное название книги";
//            e.printStackTrace("Ошибочка вышла");
        }

//        targetMethodResult = "Преступление и наказание"; //так лучше не делать


        Logger.info("В библиотеку успешно вернули книгу.");
        return targetMethodResult;
    }
}
