package com.ulianaafonina.spring.aop;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component("universityLibraryBean")
public class UniversityLibrary extends AbstractLibrary{

//    @Override
    public void getBook () {
        Logger.info("Мы берём книгу из UniversityLibrary. ");
        System.out.println("---------------------------------------------------");
    }

    public void returnBook() {
        Logger.info("Возвращаем книгу в UniversityLibrary.");
        System.out.println("---------------------------------------------------");
    }

    public void getMagazine () {
        Logger.info("Берём журнал из UniversityLibrary.");
        System.out.println("---------------------------------------------------");
    }

    public void returnMagazine () {
        Logger.info("Возвращаем журнал в UniversityLibrary.");
        System.out.println("---------------------------------------------------");
    }

    public void addBook (String person_name, Book book) {
        Logger.info("Мы добавляем книгу в UniversityLibrary. ");
        System.out.println("---------------------------------------------------");
    }

    public void addMagazine () {
        Logger.info("Мы добавляем журнал в UniversityLibrary. ");
        System.out.println("---------------------------------------------------");
    }
}
