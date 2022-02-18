package com.ulianaafonina.spring.aop;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {
    public void getBook () {
        Logger.info("Мы берём книгу.");
    }
}
