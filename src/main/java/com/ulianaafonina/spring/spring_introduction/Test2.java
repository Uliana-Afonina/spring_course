package com.ulianaafonina.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet dog = context.getBean("myDog", Pet.class);
        dog.say();

        Pet cat = context.getBean("myCat", Pet.class);
        cat.say();


        context.close();

    }
}
