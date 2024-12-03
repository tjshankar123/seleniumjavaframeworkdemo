package InterviewQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class SeleniumInterviewQA {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void LaunchBrowser(){
        driver.get("http://www.amazon.ca");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Pagesource: " + driver.getPageSource());
    }

    @Test
    public void WebElement(){
        driver.get("https://demo.nopcommerce.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));

        System.out.println("IsDisplayed: " + searchBox.isDisplayed());
        System.out.println("IsEnabled: " + searchBox.isEnabled());
        System.out.println("IsSelected: " + searchBox.isSelected());
    }

    @Test
    public void Navigate(){
        //Difference between get() and navigate.to() command :
        // get() : navigate to the page and wait till the page load.
        // navigate.to() : navigate to the page and will NOT wait until page load.

        driver.get("https://www.snapdeal.com/");
        driver.get("https://www.amazon.com");
        driver.navigate().back();
        System.out.println("Title: " + driver.getTitle()); // snapdeal page
        driver.navigate().forward();
        System.out.println("Title: " + driver.getTitle()); // amazon.ca page
        driver.navigate().refresh(); // reload page

        driver.navigate().to("http://www.google.ca");  // same as get command
        System.out.println("Title: " + driver.getTitle());
    }

    @Test
    public void findElements() {
        // findElement return single element and throw NoSuchElementException if element is not exist.
        // findElements return array of element or elements and return zero element if elements are not exist.

        driver.get("https://demo.nopcommerce.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        searchBox.sendKeys("Tharma");

        List<WebElement> footers = driver.findElements(By.xpath("//ul[@class=\"list\"]"));
        System.out.println("No of elements are " + footers.size());

        for(WebElement e: footers) {
            System.out.println(footers.size() + ": " + e.getText());
        }
    }

    @Test
    public void InputBox(){
        // getText() will return inner text
        // getAttribute(locatortype) return value in the box.
        driver.get("https://demo.nopcommerce.com/login");
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='Email']"));
        emailBox.sendKeys("Tharma@jeyasangar.com");

        System.out.println("getText(): " + emailBox.getText());
        System.out.println("getAttribute(\"value\"): " + emailBox.getAttribute("value"));

        emailBox.clear();
        emailBox.sendKeys("Test@jeyasangar.com");
        System.out.println("getAttribute(\"value\"): " + emailBox.getAttribute("value"));
    }

    @Test
    public void DropDown() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement dropDownManu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select color = new Select(dropDownManu);

        color.selectByVisibleText("Red");
        Thread.sleep(1000);
        color.selectByIndex(5);
        Thread.sleep(1000);
        color.selectByValue("10");
        Thread.sleep(1000);

        List<WebElement> options = color.getOptions();
        for (WebElement option: options) {
            option.click();
            System.out.println(option.getText());
        }
    }

    @Test
    public void CheckBox(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
    }



}
