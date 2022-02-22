package com.ulianaafonina.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("book")
public class Book {
    @Value("Преступление и наказание")
    private String name;

    @Value("Ф.М.Достоевский")
    private String author;

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Value("1866")
    private int yearOfPublication;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book " + "name = ' " + name + '\'';
    }
}
