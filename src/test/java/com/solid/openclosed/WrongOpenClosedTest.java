package com.solid.openclosed;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WrongOpenClosedTest {

    @Test
    public void propertyNullMustReturnNotNull() {
        assertNotNull(WrongOpenClosed.property2String(null));
    }

    @Test
    public void propertyNullMustReturnVoidString() {
        assertEquals(WrongOpenClosed.property2String(null), "");
    }

    @Test
    public void propertyAsStringIsTheProperty() {
        assertEquals(WrongOpenClosed.property2String("prop=value"), "prop=value");
    }

    @Test
    public void propertiesInArrayAreStringWithElementsSeparatedBySpaces() {
        String [] propertyList = new String [] {"prop1=value1","prop2=value2","prop3=value3","prop4=value4","prop5=value5"};
        assertEquals(WrongOpenClosed.property2String(propertyList), "prop1=value1 prop2=value2 prop3=value3 prop4=value4 prop5=value5");
    }


}
