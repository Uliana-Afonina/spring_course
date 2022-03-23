package com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one;

import com.ulianaafonina.spring.hibernate_tests.AbstractDaoMSQL;
import com.ulianaafonina.spring.hibernate_tests.GeneralDaoSQL;
import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Employee;
import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pmw.tinylog.Logger;

public class DaoMySQL extends AbstractDaoMSQL{

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

    public void updateEmailById(int id, String email) {
        try (SessionFactory factory = getFactory()) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            Session session = factory.getCurrentSession(); //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию
            Detail detail = session.get(Detail.class, id);
            detail.setEmail(email);
            session.getTransaction().commit(); //закрыли транзакцию

            Logger.info("Запись успешно изменена.");
        }
    }

    public void getDetailByEmployeeId(int id) {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию

            Employee employee = session.get(Employee.class, id);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit(); //закрыли транзакцию

            Logger.info("Запись успешно изменена.");
        }
    }

    public void deleteEmployeeById(int id) {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию

            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit(); //закрыли транзакцию

            Logger.info("Запись успешно изменена.");
        }
    }

    public void insertRowInEmployeesAndDetails(Employee employee, Detail detail) {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            employee.setEmpDetail(detail); //работнику добавить детали
            detail.setEmployee(employee); // деталям добавить работника

            session.beginTransaction(); //открываем транзакцию
            session.save(detail); //добавили в БД объект employee (details добавится тоже благодаря cascade)
            session.getTransaction().commit(); //закрыли транзакцию

//            System.out.println(employee);
            Logger.info("Запись успешно добавлена в таблицу employees.");
        }
    }

    public Employee getEmployeeByDetails(int id) {
        Employee employee;
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            session.beginTransaction(); //открываем транзакцию
            Detail detail = session.get(Detail.class, id);
            employee = detail.getEmployee();
            session.getTransaction().commit(); //закрыли транзакцию

//            System.out.println(employee);
            Logger.info("Запись успешно добавлена в таблицу employees.");
        }
        return employee;
    }
    public void deleteEmployeeByDetails(int id) {
        Employee employee;
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources

            session.beginTransaction(); //открываем транзакцию
            Detail detail = session.get(Detail.class, id);
            detail.getEmployee().setEmpDetail(null); //разрушаем связь foreignKey из Employee с primaryKey из Detail.
                                                        // Можем удалить детали работника без удаления работника
            session.delete(detail);
            session.getTransaction().commit(); //закрыли транзакцию

//            System.out.println(employee);
            Logger.info("Запись успешно добавлена в таблицу employees.");
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
