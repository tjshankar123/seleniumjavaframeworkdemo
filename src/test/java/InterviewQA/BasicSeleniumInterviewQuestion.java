package InterviewQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasicSeleniumInterviewQuestion{
    public WebDriver driver;

    @BeforeClass
    public void setup(){
        // WebDriverManager is automating the webdriver binary management.
        // It download the required driver binary file (if not present locally) in the cache (~/.m2/repository/webdriver)
        // It eliminate the problem of locally storing the driver binary.

        // Setup the chrome driver using WebDriverManager.
        WebDriverManager.chromedriver().setup();

        // Create driver object for firefox browser.
          driver = new ChromeDriver();
        //driver.get("http://www.toolsqa.com");
       // System.out.println("WebDriverMangerTest :" + driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void loginAutomation(){
       driver.get("https://www.browserstack.com/users/sign_in");

        driver.findElement(By.id("user_email_login")).sendKeys("testuser");
        driver.findElement(By.id("user_password")).sendKeys("password123");
        driver.findElement(By.id("user_submit")).click();

        Assert.assertEquals(driver.getTitle(), "BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool");

    }

    @Test
    public void dropDownTest(){
        driver.get("https://practice.expandtesting.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> dropdownOptionList = select.getOptions();

       Assert.assertEquals(dropdownOptionList.size(), 3 );
    }

    @Test
    public void HandleMultipleWindow() throws InterruptedException {
        driver.manage().window().maximize();

        // Load the website
        driver.get("http://www.naukri.com/");
        System.out.println(driver.getTitle());

        // It will return the parent window name as a String
        String parent=driver.getWindowHandle();

        Set<String> s=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext())
        {
            String child_window=I1.next();
            System.out.println(driver.switchTo().window(parent).getTitle());
            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                Thread.sleep(100);
                driver.close();
            }
            else{
                System.out.println("parent and child windows are same");
            }
        }
        //switch to the parent window
        driver.switchTo().window(parent);
    }
}
