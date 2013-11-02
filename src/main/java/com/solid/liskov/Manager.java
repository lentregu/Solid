package com.solid.liskov;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

    private List<String> projects;

    public Manager(String employeeId, String name) {
        super(employeeId, name);
        projects = new ArrayList<String>();
    }

    public void addProject(String project) {
        projects.add(project);
    }

    public List<String> getProjects() {
        return projects;
    }


}
