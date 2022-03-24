package com.ulianaafonina.spring.hibernate_tests.hibernate_many_to_many;

import com.ulianaafonina.spring.hibernate_tests.AbstractDaoMSQL;
import com.ulianaafonina.spring.hibernate_tests.hibernate_many_to_many.entity.Child;
import com.ulianaafonina.spring.hibernate_tests.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoMySQL extends AbstractDaoMSQL {
    @Override
    public SessionFactory getFactory() {
        return new Configuration() //можем переиспользовать factory потом во всём приложении
                .configure("hibernate.cfg.xml") //на основании какого конфигурационного файла будет строиться сессия с БД. Файл в пакете resources
                .addAnnotatedClass(Child.class) //Child.class имеет аннотации для работы с БД
                .addAnnotatedClass(Section.class) //Section.class имеет аннотации для работы с БД
                .buildSessionFactory();
    }

    public void addSection() {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            Section section1 = new Section("Football");
            Child child1 = new Child("Uliana", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasya", 6);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction(); //открываем транзакцию

            session.persist(section1);

            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");
        }
    }

    public void addChild() {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            Child child1 = new Child("Diana", 5);

            Section section1 = new Section("Piano");
            Section section2 = new Section("Swimming");
            Section section3 = new Section("Dance");

            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);

            session.beginTransaction(); //открываем транзакцию

            session.save(child1);

            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");
        }
    }


    public void cleanTable() {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её


            session.beginTransaction(); //открываем транзакцию
            session.createQuery("delete from section").executeUpdate();
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");
        }
    }

    public void getSection() {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её


            session.beginTransaction(); //открываем транзакцию
            Section section = session.get(Section.class, 1);
            System.out.println(section);
            System.out.println(section.getChildren());
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");
        }
    }

    public void getChild() {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её


            session.beginTransaction(); //открываем транзакцию
            Child child = session.get(Child.class, 4);
            System.out.println(child);
            System.out.println(child.getSections());
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");
        }
    }

    public void deleteSection(int id) {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию

            Section section = session.get(Section.class, id);
            session.delete(section);

            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");
        }
    }

    public void deleteChild(int id) {
        try (SessionFactory factory = getFactory();
             Session session = factory.getCurrentSession();) { // factory нужно закрывать в любом случае, даже если вылезет exception, поэтому используем try with resources
            //подключение к БД, живёт недолго (ровно чтоб получить данные из БД), потом закрываем её

            session.beginTransaction(); //открываем транзакцию

            Child child = session.get(Child.class, id);
            session.delete(child);

            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println("Done!");
        }
    }
}
