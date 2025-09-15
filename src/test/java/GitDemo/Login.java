package GitDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

    WebDriver driver;
    WebElement element;

    @BeforeTest
    public void setup(){

    }

    @AfterTest
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        element = driver.findElement(By.id("user-name"));

        System.out.println( driver.getTitle());
        System.out.println(element.getAttribute("data-test "));
    }
}
