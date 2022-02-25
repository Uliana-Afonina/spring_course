package com.ulianaafonina.spring.aop;

import org.pmw.tinylog.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.ulianaafonina.spring.aop.MyConfig.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibraryBean", UniversityLibrary.class);
        String bookName = universityLibrary.returnBook();
        Logger.info("В библиотеку вернули книгу: " + bookName);

        context.close();
        System.out.println("main ends");
    }
}
