package interviewQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsElementDisplayed {
    public static void main(String[] args) {

        String url = "https://www.google.ca";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));

        System.out.println(logo.isDisplayed());
        System.out.println(logo.isEnabled());
        System.out.println(logo.isSelected());

        System.out.println(logo.getText());
        System.out.println(logo.getAttribute("alt"));

        driver.quit();


    }
}
