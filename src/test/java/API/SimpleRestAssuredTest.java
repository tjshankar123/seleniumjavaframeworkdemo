package API;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.assertEquals;

public class SimpleRestAssuredTest {
    WebDriver driver;
 //   final static String URL = "https://api.github.com";
    final static String URL = "https://demoqa.com/BookStore/v1/Books";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.github.com";
        RestAssured.port = 443;
    }

    @BeforeTest
    private void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterTest
    private void tearDown() {
        driver.quit();
    }


    @Test
    public void whenRequestGet_thenOK() {
        when().request("GET", URL).then().statusCode(200);
    }

    @Test
    public void whenRequestHead_thenOK() {
        when().request("HEAD", URL).then().statusCode(200);
    }

    @Test
    public void whenMeasureResponseTime_thenOK() {
        Response response = RestAssured.get(URL);
        long timeInMS = response.time();
        long timeInS = response.timeIn(TimeUnit.SECONDS);

        assertEquals(timeInS, timeInMS / 1000);
    }

    @Test
    public void whenValidateResponseTime_thenSuccess() {
        when().get(URL).then().time(lessThan(6000L));
    }

}
