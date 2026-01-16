package packt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class WaitTypes {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";
        driver.manage().window().maximize();
    }

    @Test
    public void implicitWaitTestMouseHoverActions(){
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
        driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("Test");
    }

    @Test
    public void ExplicitWaitTest(){
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='email'])[1]")));
        emailField.sendKeys("test");

       // driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("Test");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
