package com.ulianaafonina.spring.hibernate_test;

public class Test2 {
    public static void main(String[] args) {
        daoMySQL daoMySQL = new daoMySQL();
        System.out.println(daoMySQL.updateSalaryById(1, 2500));
    }
}
