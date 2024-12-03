import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TypeOfWait {
    String url = "https://demo.guru99.com/test/newtours/register.php";

    @Test
    public void implicitWaitDemo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
        driver.close();
    }

    @Test
    public void explicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//select[@name='country']")).click();

        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(.,'ALBANIA')]")));

        driver.close();
    }

    @Test
    public void fluentWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
   //     driver.get("https://example.com");

        driver.get("https://demoqa.com/browser-windows/");

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(Duration.ofSeconds(50));
        wait.withTimeout(Duration.ofSeconds(5));

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
        {
            public Boolean apply(WebDriver arg0) {
                WebElement element = arg0.findElement(By.id("colorVar"));
                String color = element.getAttribute("color");
                System.out.println("The color if the button is " + color);
                if(color.equals("red"))
                {
                    return true;
                }
                return false;
            }
        };

        wait.until(function);
    }


}
