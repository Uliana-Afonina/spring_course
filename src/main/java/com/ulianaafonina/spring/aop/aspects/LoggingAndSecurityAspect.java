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

    @Pointcut("execution (* com.ulianaafonina.spring.aop.UniversityLibrary.*(..))")
    //любой метод с любым количеством параметров из класса UniversityLibrary
    private void allMethodsFromUniversityLibrary() {
    }

    @Pointcut("execution (public void com.ulianaafonina.spring.aop.UniversityLibrary.returnMagazine())")
    private void returnMagazineFromUniversityLibrary() {
    }

    @Pointcut("allMethodsFromUniversityLibrary() && !returnMagazineFromUniversityLibrary()")
    //все методы кроме returnMagazine()
    private void allMethodsAcceptReturnMagazineFromUniversityLibrary() {
    }

    @Before("allMethodsAcceptReturnMagazineFromUniversityLibrary()")
    public void beforeAllMethodsAcceptReturnMagazineFromUniversityLibrary() {
        Logger.info("Log#10");
    }
//    @Pointcut("execution (* com.ulianaafonina.spring.aop.UniversityLibrary.get*())")
//    private void allGetMethodsFromUniversityLibrary() {
//    }
//
//    @Pointcut("execution (* com.ulianaafonina.spring.aop.UniversityLibrary.return*())")
//    private void allReturnMethodsFromUniversityLibrary() {
//    }
//
//    @Pointcut("allGetMethodsFromUniversityLibrary() || allReturnMethodsFromUniversityLibrary()")
//    private void allGetAndReturnMethodsFromUniversityLibrary() {
//    }
//
//    @Before("allGetMethodsFromUniversityLibrary()")
//    public void beforeGetLoggingAdvice() {
//        Logger.info("writting Log#1");
//    }
//
//    @Before("allReturnMethodsFromUniversityLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        Logger.info("writting Log#2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniversityLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        Logger.info("writting Log#3");
//    }
//

//
//    @Pointcut("execution (* get*())")
//    private void allGetMethods() {
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice() {
//        Logger.info("Попытка получить книгу/журнал.");
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        Logger.info("Проверка прав на получение книги/журнала.");
//    }

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
