package com.ulianaafonina.spring.hibernate_tests.hibernate_test;

public class Test2 {
    public static void main(String[] args) {
        DaoMySQL daoMySQL = new DaoMySQL();
//        System.out.println(daoMySQL.updateSalaryById(1, 2500));
//        System.out.println(daoMySQL.updateSalaryByName("Uliana", 1333));
//    daoMySQL.deleteEmployeeById(1);
        daoMySQL.deleteEmployeeByHQLQuery("Аnn");
    }
}
