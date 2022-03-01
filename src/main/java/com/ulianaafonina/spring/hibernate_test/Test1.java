package com.ulianaafonina.spring.hibernate_test;

import com.ulianaafonina.spring.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pmw.tinylog.Logger;

public class Test1 {
    public static void main(String[] args) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
        Test1 test1 = new Test1();
        Employee employee1 = new Employee("Александр", "Смирнов", "Sales", 120);//id будет генерироваться автоматически
        test1.insertRowInEmployees(employee1);
//        test1.updateRowInEmployees(employee1);
    }

    private void insertRowInEmployees(Employee employee) {
        try (SessionFactory factory = getFactory()) {

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

//            Employee employee = new Employee(name, surname, department, salary);//id будет генерироваться автоматически
            session.beginTransaction(); //открываем транзакцию
            session.save(employee); //добавили в БД объект employee
            session.getTransaction().commit(); //закрыли транзакцию
            Logger.info("Запись успешно добавлена в таблицу employees.");
        }
    }

//    private void updateRowInEmployees(Employee employee) {
//        try (SessionFactory factory = getFactory()) {
//
//            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её
//
////            Employee employee = new Employee(name, surname, department, salary);//id будет генерироваться автоматически
//            session.beginTransaction(); //открываем транзакцию
//            session.update(employee); //добавили в БД объект employee
//            session.getTransaction().commit(); //закрыли транзакцию
//            Logger.info("Запись успешно добавлена в таблицу employees.");
//        }
//    }

    private SessionFactory getFactory() {
        return new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Employee.class) //Employee.class имеет аннотации для работы с БД
                .buildSessionFactory();
    }
}
