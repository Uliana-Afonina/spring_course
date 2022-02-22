package com.ulianaafonina.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.pmw.tinylog.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

//    @Pointcut("execution (* com.ulianaafonina.spring.aop.UniversityLibrary.*(..))")
//    //любой метод с любым количеством параметров из класса UniversityLibrary
//    private void allMethodsFromUniversityLibrary() {
//    }
//
//    @Pointcut("execution (public void com.ulianaafonina.spring.aop.UniversityLibrary.returnMagazine())")
//    private void returnMagazineFromUniversityLibrary() {
//    }
//
//    @Pointcut("allMethodsFromUniversityLibrary() && !returnMagazineFromUniversityLibrary()")
//    //все методы кроме returnMagazine()
//    private void allMethodsAcceptReturnMagazineFromUniversityLibrary() {
//    }
//
//    @Before("allMethodsAcceptReturnMagazineFromUniversityLibrary()")
//    public void beforeAllMethodsAcceptReturnMagazineFromUniversityLibrary() {
//        Logger.info("Log#10");
//    }
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




    @Before("com.ulianaafonina.spring.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod: " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType: " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName: " + methodSignature.getName());


        Logger.info("Логирование попытки получить книгу/журнал.");
        System.out.println("---------------------------------------------------");
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
