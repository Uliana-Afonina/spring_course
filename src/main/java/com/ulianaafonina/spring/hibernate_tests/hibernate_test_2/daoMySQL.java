package com.ulianaafonina.spring.hibernate_tests.hibernate_test_2;

import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Employee;
import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pmw.tinylog.Logger;

import java.util.List;

public class daoMySQL {

    private SessionFactory getFactory() {
        return new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Employee.class) //Employee.class имеет аннотации для работы с БД
                .addAnnotatedClass(Detail.class) //Detail.class имеет аннотации для работы с БД
                .buildSessionFactory();
    }

    public void insertRowInEmployees(Employee employee, Detail detail) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            employee.setEmpDetail(detail); //добавляем работнику детали о нем

            session.beginTransaction(); //открываем транзакцию
            session.save(employee); //добавили в БД объект employee (details добавится тоже благодаря cascade)
            session.getTransaction().commit(); //закрыли транзакцию

            System.out.println(employee);
            Logger.info("Запись успешно добавлена в таблицу employees.");
        }
    }


}
