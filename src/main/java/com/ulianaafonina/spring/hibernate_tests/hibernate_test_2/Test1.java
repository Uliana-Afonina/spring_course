package com.ulianaafonina.spring.hibernate_tests.hibernate_test_2;

public class Test1 {
    public static void main(String[] args) {
        daoMySQL daoMySQL = new daoMySQL();
//        Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//        Detail detail = new Detail("Moscow", "321", "Olejka@gmail.com");
//        daoMySQL.insertRowInEmployees(employee, detail);
//        daoMySQL.updateEmailById(1, "afonina6233@gmail.com");
        daoMySQL.deleteEmployeeById(2);
//        for (Employee e : employees3) {
//            System.out.println(e);
//        }
    }
}
