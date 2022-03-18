package com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_many_uni_directional;

public class Test1 {
    public static void main(String[] args) {
        DaoMySQL daoMySQL = new DaoMySQL();
//        daoMySQL.addEmployeesToDepartment();
//        daoMySQL.getDepartment(3);
//        daoMySQL.deleteEmployee(4);
        daoMySQL.deleteDepartment(3);
    }
}
