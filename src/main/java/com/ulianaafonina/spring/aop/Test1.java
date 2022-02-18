package com.ulianaafonina.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.ulianaafonina.spring.aop.MyConfig.class);

        Library library = context.getBean("libraryBean" ,Library.class);
        library.getBook();

        context.close();
    }
}
