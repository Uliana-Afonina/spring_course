package com.ulianaafonina.spring.hibernate_tests;

import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Detail;
import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDaoMSQL implements GeneralDaoSQL{
    @Override
    public SessionFactory getFactory() {
        return new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Employee.class) //Employee.class имеет аннотации для работы с БД
                .addAnnotatedClass(Detail.class) //Detail.class имеет аннотации для работы с БД
                .buildSessionFactory();
    }
}
