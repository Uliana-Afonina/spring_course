package com.ulianaafonina.spring.aop;

import org.aspectj.lang.annotation.*;
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
//
//    @AfterReturning(pointcut = "execution (* getStudents())", returning = "students")
//    /*
//      значение returning = "students" должно совпадать с именем параметра List<Student> students в методе
//     */
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
//        Student firstStudent = students.get(0);
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr." + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//
//        double avgGrade = firstStudent.getAvgGrade();
//        avgGrade = avgGrade + 1;
//        firstStudent.setAvgGrade(avgGrade);
//
//
//        Logger.info("Логируем получение списка студентов после работы метода getStudents();");
//    }

//    @AfterThrowing(pointcut = "execution (* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
//        Logger.info("логируем выброс исключения" + exception);
//    }

    @After("execution (* getStudents())")
    public  void afterGetStudentsLoggingAdvice () {
        Logger.info("Логируем нормальное окончание работы метода или выброс исключения.");
    }
}
