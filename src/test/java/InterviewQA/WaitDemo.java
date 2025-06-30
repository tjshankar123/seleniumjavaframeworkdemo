package InterviewQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitDemo {

    static WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void implicitWait(){
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement element = driver.findElement(By.id("input"));
        element.sendKeys("Selenium Webdriver Interview questions.");
        element.sendKeys(Keys.RETURN);

    }
}
