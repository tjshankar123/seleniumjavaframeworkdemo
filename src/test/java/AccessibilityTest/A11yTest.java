package AccessibilityTest;

import com.deque.axe.AXE;
import com.deque.html.axecore.results.ResultType;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import groovy.json.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.List;

import static AccessibilityTest.AmazonAllyTest.scriptUrl;
import static com.deque.html.axecore.selenium.AxeReporter.getReadableAxeResults;
import static org.testng.AssertJUnit.assertTrue;

public class A11yTest {
    WebDriver driver;
    AxeBuilder axeBuilder;
    Results axeResults;

    @BeforeClass
    public void setup() {
        axeBuilder = new AxeBuilder();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testMyPage() {

  //      driver.get("https://www.google.ca");
        driver.get("https://www.amazon.ca");

        try {
            axeResults = axeBuilder.analyze(driver);
            Assert.assertTrue(axeResults.violationFree());
            System.out.println("Issues: " + axeResults.getViolations().size());
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void testAccessibility2() {
        driver.get("https://www.amazon.ca");
        JSONObject response = new AXE.Builder(driver, scriptUrl).analyze();
    

        // Print Result
        JSONArray violations = response.getJSONArray("violations");

        if (violations.length() > 0) {
            System.out.println("Accessibility issues found.");

            for (int i = 0; i < violations.length(); i++) {
                JSONObject violation = violations.getJSONObject(i);
              //  System.out.println(violation.getString("help"));
            }
        } else {
            System.out.println("NO ISSUES FOUND.");
        }
    }

    @Test
    public void testAccessiblity_3() {
        driver.get("https://www.amazon.ca");

        Results results = new AxeBuilder().analyze(driver);
        List<Rule> violations = results.getViolations();
        if (violations.isEmpty()) {
            System.out.println("No Violation found");
        } else {
            System.out.println(violations.size() + " violations found");
        }

        // Create Report 
        String AxeReportPath = System.getProperty("user.dir") + File.separator + "AxeReports" + File.separator;
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new java.util.Date());
        String AxeViolationReportPath = AxeReportPath + "AccessiblityViolations_ " + timeStamp;

        if (getReadableAxeResults(ResultType.Violations.getKey(), driver, violations)){
            AxeReporter.writeResultsToTextFile(AxeViolationReportPath, AxeReporter.getAxeResultString());
        }

    }


}