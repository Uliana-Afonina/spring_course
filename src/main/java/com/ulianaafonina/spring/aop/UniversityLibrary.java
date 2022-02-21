package com.ulianaafonina.spring.aop;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component("universityLibraryBean")
public class UniversityLibrary extends AbstractLibrary{

//    @Override
    public void getBook () {
        Logger.info("Мы берём книгу из UniversityLibrary. ");
    }

//    protected void returnBook() {
//        Logger.info("Возвращаем книгу в UniversityLibrary.");
//    }

    public void getMagazine () {
        Logger.info("Берём журнал из UniversityLibrary.");
    }
}
