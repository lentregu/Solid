package com.solid.liskov;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Salary {

    private static final int AMOUNT_PER_YEAR = 40;

    private final static int EMPLOYEE_ID_LENGTH = 8;
    private final static int NAME_LENGTH = 40;

    private FileManager salariesFile;

    private String rootPath=null;


    public void generateSalaries(List<Employee> employees) throws IOException {

        if (employees != null) {
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            rootPath = "Salary"+ File.separator+timeLog+File.separator;
            if (createFolder(rootPath)) {
                try {
                    salariesFile = new FileManager(rootPath, "salaries-"+timeLog + ".txt");
                    for (Employee employee: employees) {
                        genEmployeeSalary(rootPath, employee);
                        addRegister(employee);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {

                    salariesFile.close();
                }
            }
        }

    }

    public String getRootPath() {
        return rootPath;
    }

    private void addRegister(Employee employee) throws IOException {

        salariesFile.writeString(employee.getEmployeeId(), EMPLOYEE_ID_LENGTH);
        salariesFile.writeString(employee.getName(), NAME_LENGTH);
        salariesFile.writeInt(employee.getGrossSalary());
        salariesFile.writeInt(employee.getSeniority());
        salariesFile.writeInt(employee.getIRPF());
        salariesFile.writeFloat(employee.getGrossSalary() - employee.getGrossSalary() * employee.getIRPF()/100
                + employee.getSeniority() * AMOUNT_PER_YEAR);
    }

    private void genEmployeeSalary(String rootPath, Employee employee) throws IOException{
        FileManager employeeSalary = new FileManager(rootPath, employee.getName());

        employeeSalary.writeString(employee.getEmployeeId(), EMPLOYEE_ID_LENGTH);
        employeeSalary.writeString(employee.getName(), NAME_LENGTH);
        employeeSalary.writeInt(employee.getGrossSalary());
        employeeSalary.writeInt(employee.getSeniority());
        employeeSalary.writeInt(employee.getIRPF());
        employeeSalary.writeFloat(employee.getGrossSalary() - employee.getGrossSalary() * employee.getIRPF() / 100
                + employee.getSeniority() * AMOUNT_PER_YEAR);
        employeeSalary.close();
    }

    private boolean createFolder(String rootPath) {
        return new File(rootPath).mkdirs();
    }

}
