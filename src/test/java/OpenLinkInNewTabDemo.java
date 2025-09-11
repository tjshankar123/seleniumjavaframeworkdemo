import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OpenLinkInNewTabDemo {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String url = "https://demo.nopcommerce.com/";

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        // Method1:  Open Register link in a different tab.
         driver.switchTo().newWindow(WindowType.TAB);
         driver.get(url + "/register");

         driver.findElement(By.id("gender-male")).click();
         driver.findElement(By.id("FirstName")).sendKeys("Tom");
        driver.findElement(By.id("LastName")).sendKeys("Tucker");
        driver.findElement(By.id("Email")).sendKeys("tom.tucker@email.com");


        Thread.sleep(2000);

        driver.quit();




    }


}
