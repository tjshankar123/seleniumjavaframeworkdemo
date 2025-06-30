import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsDemo {
    // 1. Hard Assertion : assertEquals(), assertTrue(), assertFalse()
    // 2. Soft Assertion : Test execution continue even if the test fails. Errors reported at the end using assertAll() method.
    @Test
    public void hardAssertionTest(){
        String actualTitle = "Welcome Page";
        String expectedTitle = "welcome Page";

        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match.");
    }

    @Test
    public void softAssertionTest(){
        SoftAssert softassert = new SoftAssert();

        String actualTitle = "Welcome Page";
        String expectedTitle = "welcome Page";


        softassert.assertEquals(actualTitle, expectedTitle, "Title does not match in softAssert");
        softassert.assertAll();

    }

}
