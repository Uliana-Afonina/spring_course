package com.ulianaafonina.spring.hibernate_test;

import com.ulianaafonina.spring.hibernate_test.entity.Employee;

public class Test2 {
    public static void main(String[] args) {
        daoMySQL daoMySQL = new daoMySQL();
//        System.out.println(daoMySQL.updateSalaryById(1, 2500));
//        System.out.println(daoMySQL.updateSalaryByName("Uliana", 1333));
    daoMySQL.deleteSalaryById(1);

    }
}
