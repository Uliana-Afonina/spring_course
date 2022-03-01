package com.ulianaafonina.spring.hibernate_test;

import com.ulianaafonina.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
        try (SessionFactory factory = new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Employee.class) //Employee.class имеет аннотации для работы с БД
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            Employee employee = new Employee("Uliana", "Afonina", "IT", 500);//id будет генерироваться автоматически
            session.beginTransaction(); //открываем транзакцию
            session.save(employee); //добавили в БД объект employee
            session.getTransaction().commit(); //закрыли транзакцию
        }

    }
}
