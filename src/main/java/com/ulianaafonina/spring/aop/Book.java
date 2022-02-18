package com.ulianaafonina.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("book")
public class Book {
    @Value("Преступление и наказание")
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book " + "name = ' " + name + '\'';
    }
}
