package com.ulianaafonina.spring.hibernate_tests.hibernate_test_2;

import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Detail;
import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        daoMySQL daoMySQL = new daoMySQL();
        Employee employee = new Employee("Uliana", "Afonina", "IT", 500);
        Detail detail = new Detail("Sevastopol", "123", "afonina6233@gmaol.com");
        daoMySQL.insertRowInEmployees(employee, detail);

//        for (Employee e : employees3) {
//            System.out.println(e);
//        }
    }
}
