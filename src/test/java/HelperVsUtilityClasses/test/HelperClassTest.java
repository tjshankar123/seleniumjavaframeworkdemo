package HelperVsUtilityClasses.test;

import HelperVsUtilityClasses.MyHelperClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

//https://www.baeldung.com/java-helper-vs-utility-classes
public class HelperClassTest {
    /*
    A helper class provides functionalities necessary for the overall running of a Java program.
    Helper classes contain methods used by other classes to perform repetitive tasks, which aren’t the core purpose of an application.
     */
    @Test
    void whenCreatingHelperObject_thenHelperObjectShouldBeCreated() {
        MyHelperClass myHelperClassObject = new MyHelperClass(0.10);
        assertNotNull(myHelperClassObject);
        assertEquals(90, myHelperClassObject.discountedPrice(100.00));

        int[] numberArray = {15, 23, 66, 3, 51, 79};
        assertEquals( 79, MyHelperClass.getMaxNumber(numberArray));
        assertEquals(3, MyHelperClass.getMinNumber(numberArray));
    }
}
