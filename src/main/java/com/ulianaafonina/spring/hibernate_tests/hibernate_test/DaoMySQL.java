package com.ulianaafonina.spring.hibernate_tests.hibernate_test;

import com.ulianaafonina.spring.hibernate_tests.AbstractDaoMSQL;
import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Detail;
import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pmw.tinylog.Logger;

import java.util.List;

public class DaoMySQL extends AbstractDaoMSQL{

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

    public List<Employee> getAllEmployees() {
        try (SessionFactory factory = getFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //открываем транзакцию
            List employees = session.createQuery("from Employee") //указано имя класса, связанного с БД
                    .getResultList();
            session.getTransaction().commit(); //закрыли транзакцию
            return employees;
        }
    }

    public List<Employee> getEmployeesByName(String name) {
        try (SessionFactory factory = getFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //открываем транзакцию
            List employees = session
                    .createQuery("from Employee " + "where name = '" + name + "'") //name - имя поля в классе Employee.class
                    .getResultList();
            session.getTransaction().commit(); //закрыли транзакцию
            return employees;
        }
    }
    public List<Employee> getEmployeesByNameAndSalary(String name, int salary) {
        try (SessionFactory factory = getFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //открываем транзакцию
            List employees = session
                    .createQuery("from Employee " + "where name = '" + name + "' AND salary>" + salary) //name - имя поля в классе Employee.class
                    .getResultList();
            session.getTransaction().commit(); //закрыли транзакцию
            return employees;
        }
    }

    public Employee updateSalaryById(int id, int newSalary) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Employee employee = session.get(Employee.class, id);
            employee.setSalary(newSalary);
            session.getTransaction().commit(); //закрыли транзакцию

            System.out.println(employee);
            Logger.info("Запись успешно изменена.");
            return employee;
        }
    }

    public List<Employee> updateSalaryByName(String name, int newSalary) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            session.createQuery("update Employee set salary=" + newSalary + " where name='" + name + "'").executeUpdate();
            List employees = session.createQuery("from Employee") //указано имя класса, связанного с БД
                    .getResultList();
            session.getTransaction().commit(); //закрыли транзакцию

            Logger.info("Запись успешно изменена.");
            return employees;
        }
    }

    public void deleteEmployeeById(int id) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            session.getTransaction().commit(); //закрыли транзакцию

            System.out.println(employee);
            Logger.info("Запись успешно удалена из таблицы employees.");
        }
    }
    public void deleteEmployeeByHQLQuery(String name) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            session.createQuery("delete Employee where name='" + name + "'").executeUpdate();
            session.getTransaction().commit(); //закрыли транзакцию

            Logger.info("Запись успешно удалена из таблицы employees.");
        }
    }

    public SessionFactory getFactory() {
        return new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Employee.class) //Employee.class имеет аннотации для работы с БД
                .addAnnotatedClass(Detail.class) //Detail.class имеет аннотации для работы с БД
                .buildSessionFactory();
    }
}
