package HelperVsUtilityClasses.test;

import HelperVsUtilityClasses.MyUtilityClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

//https://www.baeldung.com/java-helper-vs-utility-classes
public class UtilityClassTest {
    /*
    A utility class in Java is a class that provides static methods that are accessible for use across an application.
    The static methods in utility classes are used for performing common routines in our application.
     */
    @Test
    void whenUsingUtilityMethods_thenAccessMethodsViaClassName(){
        assertEquals("INIUBONG", MyUtilityClass.returnUpperCase("iniubong"));
        assertEquals("accra", MyUtilityClass.returnLowerCase("AcCrA"));
    }
}
