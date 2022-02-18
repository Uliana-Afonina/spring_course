package com.ulianaafonina.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.ulianaafonina.spring.aop.MyConfig.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibraryBean" , UniversityLibrary.class);
        universityLibrary.getBook("Преступление и наказание");
//        universityLibrary.returnBook();
//        universityLibrary.getMagazine();

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibraryBean", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
