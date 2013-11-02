package com.solid.liskov;

import com.mongodb.BasicDBObject;

public abstract class Employee {

    private String name;
    private String employeeId;
    private int seniority;
    private int grossSalary;
    private int IRPF;

    public Employee(String employeeId, String name) {

        this.employeeId = employeeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }

    public int getIRPF() {
        return IRPF;
    }

    public void setIRPF(int IRPF) {
        this.IRPF = IRPF;
    }

}
