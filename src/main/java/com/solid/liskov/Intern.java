package com.solid.liskov;

/**
 * The intern is a Developer with an special employeeId and without salary
 */
public class Intern extends Developer {

    public Intern(String employeeId, String name) {
        super(employeeId, name);
    }

    @Override
    public void setGrossSalary(int grossSalary) {
        super.setGrossSalary(0);
    }

}
