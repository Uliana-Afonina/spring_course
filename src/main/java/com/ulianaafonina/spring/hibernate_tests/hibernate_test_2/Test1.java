package com.ulianaafonina.spring.hibernate_tests.hibernate_test_2;

import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Detail;
import com.ulianaafonina.spring.hibernate_tests.hibernate_test_2.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        daoMySQL daoMySQL = new daoMySQL();
        Employee employee = new Employee("Nikolay", "Fedotov", "HR", 400);
        Detail detail = new Detail("New-York", "000", "niky@gmail.com");
//        daoMySQL.insertRowInEmployees(employee, detail);
//        daoMySQL.updateEmailById(1, "afonina6233@gmail.com");
//        daoMySQL.deleteEmployeeById(2);
        daoMySQL.insertRowInEmployeesAndDetails(employee, detail);
    }
}
