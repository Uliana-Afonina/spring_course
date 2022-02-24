package com.ulianaafonina.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.pmw.tinylog.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.SplittableRandom;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution (* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        Logger.info("Логируем получение списка студентов перед методом getStudents();");
    }

    @AfterReturning(pointcut = "execution (* getStudents())", returning = "students")
    /*
      значение returning = "students" должно совпадать с именем параметра List<Student> students в методе
     */
    public void afterGetStudentsLoggingAdvice(List<Student> students) {
        Student firstStudent = students.get(0);
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr." + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 1;
        firstStudent.setAvgGrade(avgGrade);


        Logger.info("Логируем получение списка студентов после работы метода getStudents();");
    }
}
