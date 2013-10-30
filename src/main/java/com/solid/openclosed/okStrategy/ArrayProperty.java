package com.solid.openclosed.okstrategy;

public class ArrayProperty implements IOpenClosedProperty {

    private String [] properties;

    public ArrayProperty(String[] properties) {
		super();
		this.properties = properties;
	}

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] property) {
		this.properties = property;
	}
	
	@Override
	public String toString() {
		StringBuilder stringProperties = new StringBuilder();
		
		for (String prop: properties) {
			stringProperties.append(stringProperties.length() == 0 ? prop: " "+prop);
		}
		
		return stringProperties.toString().trim();
	}


}
