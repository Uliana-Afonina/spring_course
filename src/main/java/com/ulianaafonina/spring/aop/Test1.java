package com.ulianaafonina.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.ulianaafonina.spring.aop.MyConfig.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibraryBean" , UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);
        universityLibrary.getBook(book);

//        System.out.println( "\n" + book.getName());

//        universityLibrary.returnBook();
//        universityLibrary.getMagazine();

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibraryBean", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
