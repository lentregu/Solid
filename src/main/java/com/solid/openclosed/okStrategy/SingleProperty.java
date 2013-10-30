package com.solid.openclosed.okstrategy;

public class SingleProperty implements IOpenClosedProperty {

    private String property;

    public SingleProperty(String property) {
        super();
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return property;
    }
}