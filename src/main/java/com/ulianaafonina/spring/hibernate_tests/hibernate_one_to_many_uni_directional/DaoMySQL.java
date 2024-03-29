package com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_many_uni_directional;

import com.ulianaafonina.spring.hibernate_tests.AbstractDaoMSQL;
import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_many_uni_directional.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoMySQL extends AbstractDaoMSQL {

    @Override
    public SessionFactory getFactory() {
        return new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Employee.class) //Employee.class имеет аннотации для работы с БД
                .addAnnotatedClass(Department.class) //Detail.class имеет аннотации для работы с БД
                .buildSessionFactory();
    }

    public void addEmployeesToDepartment() {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            Department department = new Department("HR", 500, 1500);
            Employee employee1 = new Employee("Kristina", "Udina", 900);
            Employee employee2 = new Employee("Anton", "Biev", 790);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);

            session.beginTransaction(); //открываем транзакцию
            session.save(department);
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");

        }
    }

    public void getDepartment(int id) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Department department = session.get(Department.class, id);
            System.out.println(department);
            System.out.println(department.getEmployees());
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");

        }
    }

    public void getEmployee(int id) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Employee employee = session.get(Employee.class, id);
            System.out.println(employee);
//            System.out.println(employee.getDepartment());
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");

        }
    }

    public void deleteEmployee(int id) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            System.out.println(employee);
//            System.out.println(employee.getDepartment());
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");

        }
    }

    public void deleteDepartment(int id) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Department department = session.get(Department.class, id);
            session.delete(department);
            System.out.println(department);
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");

        }
    }
}
