package com.solid.openclosed;

public class WrongOpenClosed
{
		
	public static final String property2String(Object property) {
		if(property == null) {
			return "";
		} else if (property instanceof String) {
			return (String)property;
		} else if (property instanceof String[]) {
			String[] array = (String[])property;
			if(array.length == 1) {
				return array[0];
			} else {
				StringBuilder result = new StringBuilder();
				for (int i = 0; i < array.length; i++) {
					result.append(array[i]);
					result.append(' ');
				}
				return result.toString().trim();
			}
		} else {
			return property.toString();
		}
	}
}
