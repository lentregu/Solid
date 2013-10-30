package com.solid.openclosed.okstrategy;


public class OkOpenClosed
{
	public static final String property2String(IOpenClosedProperty property)
	{
		return property == null ? "" : property.toString();
	}
}
