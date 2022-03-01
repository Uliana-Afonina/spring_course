package com.ulianaafonina.spring.hibernate_test;

import com.ulianaafonina.spring.hibernate_test.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Аnn", "Ffa", "IT", 520);//id будет генерироваться автоматически
        daoMySQL daoMySQL = new daoMySQL();
//        int id = daoMySQL.insertRowInEmployees(employee1);
        int id = 13;
        System.out.println(id);
        System.out.println(daoMySQL.getRowFromEmployees(id));
    }
}
