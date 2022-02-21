package com.ulianaafonina.spring.aop;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component("universityLibraryBean")
public class UniversityLibrary extends AbstractLibrary{

//    @Override
    public void getBook () {
        Logger.info("Мы берём книгу из UniversityLibrary. ");
    }

    public void returnBook() {
        Logger.info("Возвращаем книгу в UniversityLibrary.");
    }

    public void getMagazine () {
        Logger.info("Берём журнал из UniversityLibrary.");
    }

    public void returnMagazine () {
        Logger.info("Возвращаем журнал в UniversityLibrary.");
    }

    public void addBook () {
        Logger.info("Мы добавляем книгу в UniversityLibrary. ");
    }

    public void addMagazine () {
        Logger.info("Мы добавляем журнал в UniversityLibrary. ");
    }
}
