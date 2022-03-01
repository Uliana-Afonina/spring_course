package com.ulianaafonina.spring.hibernate_test;

import com.ulianaafonina.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pmw.tinylog.Logger;

public class daoMySQL {

    private SessionFactory getFactory() {
        return new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Employee.class) //Employee.class имеет аннотации для работы с БД
                .buildSessionFactory();
    }

    public int insertRowInEmployees(Employee employee) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            session.save(employee); //добавили в БД объект employee
            session.getTransaction().commit(); //закрыли транзакцию

            int myId = employee.getId();

            System.out.println(employee);
            Logger.info("Запись успешно добавлена в таблицу employees.");
            return myId;
        }
    }

    public Employee getRowFromEmployees(int id) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Employee employee = session.get(Employee.class, id);
            session.getTransaction().commit(); //закрыли транзакцию

            System.out.println(employee);
            Logger.info("Запись успешно получена из таблицы employees.");
            return employee;
        }
    }


}
