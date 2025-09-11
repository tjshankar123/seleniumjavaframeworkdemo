import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipDemo {
    /*
        In Selenium, a tooltip refers to the small pop-up box that appears when a user hovers over an element—usually
        providing additional information about that element.
     */
    public static void main(String[] args) {
        String url = "https://jqueryui.com/tooltip/";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.switchTo().frame(0);
        WebElement inputBox = driver.findElement(By.id("age"));

        String toolTipText = inputBox.getAttribute("title");
        System.out.println(toolTipText);

        driver.quit();


    }
}
