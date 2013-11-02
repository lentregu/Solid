package com.solid.liskov;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Employee employee1 = new Intern("1", "Gonzalo");
        Employee employee2 = new Developer("2", "Jose");
        employee2.setGrossSalary(4000);
        employee2.setIRPF(30);
        employee2.setSeniority(6);
        Employee employee3 = new Manager("3", "Juan");
        employee3.setGrossSalary(3500);
        employee3.setIRPF(30);
        employee3.setSeniority(4);

        List<Employee> employees = new ArrayList<Employee>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Salary salary = new Salary();
        try {
            salary.generateSalaries(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("UserDir: " + System.getProperty("user.dir"));
    }
}
