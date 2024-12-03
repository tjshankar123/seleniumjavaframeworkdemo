import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyAssertUse {

    @Test
    public void softAssertionTest(){

        //Creating softAssert object
        SoftAssert softAssert = new SoftAssert();

        //Assertion failing
        softAssert.fail("Failing first assertion");
        System.out.println("Failing 1");

        //Assertion failing
        softAssert.fail("Failing second assertion");
        System.out.println("Failing 2");
        //Collates the assertion results and marks test as pass or fail
        softAssert.assertAll();
    }
    @Test
    public void assertionTest(){

        //Assertion Passing
        Assert.assertTrue(1+2 == 3);
        System.out.println("Passing 1");

        //Assertion failing
        Assert.fail("Failing second assertion");
        System.out.println("Failing 2");
    }
}
