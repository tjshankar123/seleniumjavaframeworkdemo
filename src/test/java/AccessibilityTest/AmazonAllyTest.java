package AccessibilityTest;

import com.deque.axe.AXE;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class AmazonAllyTest {

    WebDriver driver;
    static final URL scriptUrl = AmazonAllyTest.class.getResource("/axe.min.js");


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.amazon.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicTest(){
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No violations found.", true);
        }else {
            assertTrue(AXE.report(violations), false);
        }
    }

    @Test
    public void amazonAllyTest(){
        JSONObject responseJson = new AXE.Builder(driver, scriptUrl).analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No Violation Found.", true);
            System.out.println("No Errors.");
        }
        else {
            AXE.writeResults("amazonAllyTest", responseJson);
            assertTrue( AXE.report(violations), false );
        }
    }
}
