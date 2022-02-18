package com.ulianaafonina.spring.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person {
    @Autowired
    @Qualifier("catBean")
    private Pet pet;
//    @Value("${person.surname}")
    private String surname;
//    @Value("${person.age}")
    private int age;

//    @Autowired
//    public Person(@Qualifier("catBean") Pet pet) {
//        System.out.println("Создан бин Person");
//        this.pet = pet;
//    }

    public Person() {
        System.out.println("Создан бин Person");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        System.out.println("Class Person: set surname");
    }

    public int getAge() {
        return age;
    }

    public void setAge (int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }


// pet -> setPet
//    @Autowired
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public void callYourPet () {
        System.out.println("Привет, мой милый питомец!");
        pet.say();
    }
}
