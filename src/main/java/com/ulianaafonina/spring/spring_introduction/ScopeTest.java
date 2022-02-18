package com.ulianaafonina.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog dog1 = context.getBean(Dog.class);
        dog1.say();
//        Dog dog2 = context.getBean(Dog.class);
//
//        Person person = context.getBean(Person.class);
//        person.callYourPet();
    }
}
