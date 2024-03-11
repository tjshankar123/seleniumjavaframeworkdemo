package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsDemo {
        public static void main(String[] args) throws InterruptedException {

            // Relative locators are a new advancement that was introduced in Selenium 4 which
            // was previously called friendly locators.
            // above(), below(), toLeftOf(), toRightOf(), near()

            WebDriver driver;
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.browserstack.com/");

            WebElement appLive = driver.findElement(By.cssSelector("a.product-card-app-live"));
            WebElement getADemo = driver.findElement(RelativeLocator.with(By.tagName("button")).above(appLive));
            getADemo.click();
        }

}
