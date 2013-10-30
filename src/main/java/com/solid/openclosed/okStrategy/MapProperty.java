package com.solid.openclosed.okstrategy;

import java.util.Map;

public class MapProperty implements IOpenClosedProperty {

	private Map<String, String> properties;

    public Map getProperties() {
        return properties;
    }

    public MapProperty(Map<String, String> properties) {
        super();
        this.properties = properties;
    }

	public void setProperties(Map properties) {
		this.properties = properties;
	}
	
	@Override
	public String toString() {
		StringBuilder stringProperties = new StringBuilder();
		
		for (String key : properties.keySet()) {
			String prop = key + "=" + properties.get(key);
			stringProperties.append(stringProperties.length() == 0 ? prop: " "+ prop);		
		}
		
		return stringProperties.toString().trim();
	}


}
