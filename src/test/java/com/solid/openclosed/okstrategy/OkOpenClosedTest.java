package com.solid.openclosed.okstrategy;

import com.solid.openclosed.WrongOpenClosed;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OkOpenClosedTest {

    @Test
    public void propertyNullMustReturnNotNull() {
        assertNotNull(OkOpenClosed.property2String(null));
    }

    @Test
    public void propertyNullMustReturnVoidString() {
        assertEquals(OkOpenClosed.property2String(null), "");
    }

    @Test
    public void propertyAsStringIsTheProperty() {
        assertEquals(OkOpenClosed.property2String(new SingleProperty("prop=value")), "prop=value");
    }

    @Test
    public void propertiesInArrayAreStringWithElementsSeparatedBySpaces() {
        String [] propertyList = new String [] {"prop1=value1","prop2=value2","prop3=value3","prop4=value4","prop5=value5"};
        assertEquals(OkOpenClosed.property2String(new ArrayProperty(propertyList)), "prop1=value1 prop2=value2 prop3=value3 prop4=value4 prop5=value5");
    }

}
