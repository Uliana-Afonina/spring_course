package com.ulianaafonina.spring.hibernate_tests.hibernate_test_2;

import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Detail;
import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        daoMySQL daoMySQL = new daoMySQL();
//        Employee employee = new Employee("Grigoriy", "Fedorov", "HR", 900);
//        Detail detail = new Detail("Samara", "876", "grisha@gmail.com");
//        daoMySQL.insertRowInEmployees(employee, detail);
//        daoMySQL.updateEmailById(1, "afonina6233@gmail.com");
//        daoMySQL.deleteEmployeeById(2);
//        daoMySQL.insertRowInEmployeesAndDetails(employee, detail);
//        Employee employee2 = daoMySQL.getEmployeeByDetails(4);
//        System.out.println(employee2);
        daoMySQL.deleteEmployeeByDetails(1);
    }
}
