package com.ulianaafonina.spring.hibernate_tests.hibernate_many_to_many;

public class Test {
    public static void main(String[] args) {
        DaoMySQL daoMySQL = new DaoMySQL();
//        daoMySQL.addSection();
//        daoMySQL.addChild();
//         daoMySQL.cleanTable();
//        daoMySQL.getSection();
//        daoMySQL.getChild();
//        daoMySQL.deleteSection(10);
        daoMySQL.deleteChild(5);
    }
}
