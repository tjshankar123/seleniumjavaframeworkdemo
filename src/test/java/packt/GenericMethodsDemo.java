package packt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class GenericMethodsDemo {
    private WebDriver driver;
    private String baseUrl;
    private GnenericMethods gm;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";
        gm = new GnenericMethods(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testMethod() {
        driver.get(baseUrl);
       // WebElement element = driver.findElement(By.id("name"));
        WebElement element = gm.getElement("name", "id");
        element.sendKeys("test");
    }

    @Test
    public void testMethodList(){
        driver.get(baseUrl);
        if(gm.isElementPresent("//input[@type='text']","xpath")){
            System.out.println("Element is present.");
            List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
        }
        else {
            System.out.println("Elements not found. " + "//input[@type='text']");
        }

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
