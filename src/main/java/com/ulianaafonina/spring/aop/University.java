package com.ulianaafonina.spring.aop;

import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student student1 = new Student("Afonina Uliana", 4, 7.5);
        Student student2 = new Student("Michael Ivanov", 2, 8.3);
        Student student3 = new Student("Elena Sidorova", 1, 9.1);

        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public List<Student> getStudents (){
        Logger.info("Начало работы метода getStudents() ");
        System.out.println(students.get(3));
        Logger.info("Информация о студентах: ");
        System.out.println(students);
//        Logger.info(this::getStudents);
        return students;
    }
}
