package com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_many_bi_directional;

public class Test1 {
    public static void main(String[] args) {
        DaoMySQL daoMySQL = new DaoMySQL();

//        daoMySQL.addEmployeesToDepartment();
//    daoMySQL.getDepartment(1);
    daoMySQL.getEmployee(1);
    }
}
