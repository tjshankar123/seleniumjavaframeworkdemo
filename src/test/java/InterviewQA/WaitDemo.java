package InterviewQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitDemo {

    static WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void implicitWait(){
        /*
        Global Scope: It applies to all elements for the entire duration of the WebDriver instance.
        Polls the DOM: It checks for the element's presence at regular intervals until the timeout is reached or the element is found.
        Disadvantages: It can slow down tests if many elements are not found immediately, as it will always wait for the full timeout before failing.
        It's not suitable for waiting for specific conditions, like an element becoming clickable or visible.
         */
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement element = driver.findElement(By.id("input"));
        element.sendKeys("Selenium Webdriver Interview questions.");
        element.sendKeys(Keys.RETURN);

    }

    @Test
    public void explicitWaitTest(){
        driver.get("https://gmail.com");
        // maximized the browser window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // saving the GUI element reference into a "element" variable of WebElement type
         WebElement element = driver.findElement(By.id("identifierId"));
        // entering username
         element.sendKeys("dummy@gmail.com");
         element.sendKeys(Keys.RETURN);
        // entering password
         driver.findElement(By.name("Passwd")).sendKeys("password");
        // clicking signin button
         driver.findElement(By.id("signIn")).click();

         // explicit wait - to wait for the compose button to be click-able
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
        // click on the compose button as soon as the "compose" button is visible
        driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();

    }
}
