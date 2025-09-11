import  io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterTest
    public void cleanup(){
        driver.close();;
    }

    @Test
    public void alertDemo() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage= driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(5000);

        // Accepting alert
        alert.accept();
    }

    @Test
    public void alertDemo2() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        // Enter customer ID and submit
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        // Switch to alert
        Alert alert = driver.switchTo().alert();

        // Get alert text
        String alertMessage = alert.getText();
        System.out.println("Alert message: " + alertMessage);
     //   alert.accept(); // OK
       alert.dismiss(); // Cancel

        // Accept the alert
    //    alert.dismiss();
    }
}

