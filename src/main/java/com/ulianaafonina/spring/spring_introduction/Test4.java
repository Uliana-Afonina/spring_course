package com.ulianaafonina.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog dog1 = context.getBean("myPet", Dog.class);
//        dog1.setName("Белко");
        Dog dog2 = context.getBean("myPet", Dog.class);
//        dog2.setName("Стрелко");

        System.out.println("Переменные ссылаются на один и тот же объект?" + (dog1 == dog2));
        System.out.println(dog1);
        System.out.println(dog2);

//        System.out.println(dog1.getName());
//        System.out.println(dog2.getName());

        context.close();
    }
}
