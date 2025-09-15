package GitDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShoppingCartTest {
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
    public void addItems(){

    }
}
