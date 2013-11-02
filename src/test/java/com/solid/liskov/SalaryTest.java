package com.solid.liskov;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.solid.srp.User;
import com.solid.srp.UserDB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SalaryTest {

//    @InjectMocks
//    private Developer mockDeveloper;
//    @InjectMocks
//    private Manager mockManager;
//    @InjectMocks
//    private Intern mockIntern;

    private Developer mockDeveloper= mock(Developer.class);
    private Manager mockManager = mock(Manager.class);
    private Intern mockIntern = mock(Intern.class);


//    @InjectMocks
//    private ArrayList<Employee> mockEmployees;
//      private List<Employee> mockEmployees = (List<Employee>)mock(List.class);
      private ArrayList<Employee> mockEmployees = mock(ArrayList.class);

    @Before
    public void setUp() throws UnknownHostException {


        when(mockManager.getEmployeeId()).thenReturn("1");
        when(mockManager.getGrossSalary()).thenReturn(4000);
        when(mockManager.getSeniority()).thenReturn(8);
        when(mockManager.getIRPF()).thenReturn(35);
        when(mockManager.getName()).thenReturn("Manager");

        when(mockDeveloper.getEmployeeId()).thenReturn("2");
        when(mockDeveloper.getGrossSalary()).thenReturn(4500);
        when(mockDeveloper.getSeniority()).thenReturn(8);
        when(mockDeveloper.getIRPF()).thenReturn(35);
        when(mockDeveloper.getName()).thenReturn("Developer");

        when(mockIntern.getEmployeeId()).thenReturn("3");
        when(mockIntern.getGrossSalary()).thenReturn(0);
        when(mockIntern.getSeniority()).thenReturn(0);
        when(mockIntern.getName()).thenReturn("Intern");
        setIterator();

    }

    private void setIterator() {

        Iterator employeesIterator = mock(Iterator.class);
        when(employeesIterator.hasNext()).thenReturn(true, true, true, false);
        when(employeesIterator.next()).thenReturn(mockDeveloper)
                .thenReturn(mockManager).thenReturn(mockIntern);

        when(mockEmployees.iterator()).thenReturn(employeesIterator);
    }

    @Test
    public void generateSalariesNullListRootPathIsNull() throws IOException {
        Salary salary = new Salary();
        salary.generateSalaries(null);
        assertNull(salary.getRootPath());
    }

    @Test
    public void generateSalariesCreateOneAggregationFileAndOneFilePerEmployee() throws IOException {
        Salary salary = new Salary();
        salary.generateSalaries(mockEmployees);
        assertTrue(new File(salary.getRootPath()).exists());
        setIterator();
        for (Employee employee: mockEmployees)     {
            if (employee instanceof Intern) {
                assertFalse(new File(salary.getRootPath() + employee.getName()).exists());
            }
            else {
                assertTrue(new File(salary.getRootPath() + employee.getName()).exists());
            }
        }
    }
}
