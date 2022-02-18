package com.ulianaafonina.spring.spring_introduction;

import org.springframework.stereotype.Component;

//@Component("catBean")
public class Cat implements Pet {
    public Cat() {
        System.out.println("Кошко-бин создан");
    }

    @Override
    public void say() {
        System.out.println("Мяв-мяв!");
    }
}
