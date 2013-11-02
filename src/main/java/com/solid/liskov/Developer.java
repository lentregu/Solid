package com.solid.liskov;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee {

    private List<Languages> languages;

    public Developer(String employeeId, String name) {
        super(employeeId, name);
        languages = new ArrayList<Languages>();
    }

    public void addLanguage(Languages language) {
        languages.add(language);
    }

    public List<Languages> getLanguages() {
        return languages;
    }
}
