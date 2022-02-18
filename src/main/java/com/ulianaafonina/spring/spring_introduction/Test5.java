package com.ulianaafonina.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog dog1 = context.getBean("myPet", Dog.class);
        dog1.say();

        Dog dog2 = context.getBean("myPet", Dog.class);

        dog2.say();
        context.close();
    }
}
