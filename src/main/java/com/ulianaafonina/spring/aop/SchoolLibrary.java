package com.ulianaafonina.spring.aop;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component("schoolLibraryBean")
public class SchoolLibrary extends AbstractLibrary {

    @Override
    public void getBook () {
        Logger.info("Мы берём книгу из SchoolLibrary.");
    }
}
