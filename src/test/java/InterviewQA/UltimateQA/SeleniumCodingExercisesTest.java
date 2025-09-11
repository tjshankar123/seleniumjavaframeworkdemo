package InterviewQA.UltimateQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static org.testng.Assert.*;


public class SeleniumCodingExercisesTest {
    WebElement element;
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void elementQuiz1(){

        driver.get("https://www.saucedemo.com/");
        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        // Validation of the element
        assertTrue(element.isDisplayed());

    }

    @Test
    public void typeOfLocators(){

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        //ID
        element = driver.findElement(By.id("idExample"));
        assertTrue(element.isDisplayed());

        //Name
        element = driver.findElement(By.name("button1"));
        assertTrue(element.isDisplayed());

        // Tag name
        element = driver.findElement(By.tagName("h3"));
        assertTrue(element.isDisplayed());

        //CSS selector
        element = driver.findElement(By.cssSelector("#simpleElementsLink"));
        assertTrue(element.isDisplayed());

        // xpath
        element = driver.findElement(By.xpath("//a[normalize-space()='Click Me']"));
        assertTrue(element.isDisplayed());

        // Link text
        element = driver.findElement(By.linkText("Click this link"));
        assertTrue(element.isDisplayed());

        // Partial link test
        element = driver.findElement(By.partialLinkText("this link"));
        assertTrue(element.isDisplayed());
    }

    @Test
    public void dropdown_quiz_1(){
        /*
         * Go here "https://the-internet.herokuapp.com/dropdown"
         * Select option 1 from the dropdown
         * Assert that option 1 is selected
         * Assert that option 2 is NOT selected
         */

        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.xpath("//select[@id='dropdown']")).click();

        WebElement option1 = driver.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = driver.findElement(By.xpath("//option[@value='2']"));

        option1.click();
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
    }

    @Test
    public void hoverOver_quiz_2(){
        /*
         * Go to "https://the-internet.herokuapp.com/hovers"
         * Hover over the first image
         * Assert that on hover there is text that is displayed below "name: user1"
         * */

        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstImage = driver.findElement(By.xpath("//div[@class='figure'][1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstImage).perform();

        /* If you want to perform more than once, use build() then invoke perform on that Action object
                Action moveTo = actions.moveToElement(firstImage).build();
                moveTo.perform();
        */

        WebElement text = driver.findElement(By.xpath("//h5[normalize-space()='name: user1']"));
        assertTrue(text.isDisplayed(), "user1 should appear because we hovered the image");
    }

    @Test
    public void alert_quiz_3(){
        /*
         * https://the-internet.herokuapp.com/context_menu
         * Right click
         * close alert
         * driver.switchTo().alert().accept();
         * */

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement image = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(image).perform(); // contextClick is for Right-Click

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void keyPress_quiz_4() {
        /*
         * go to "https://the-internet.herokuapp.com/key_presses"
         * send right arrow key to the input box
         * assert that you got this text back "You entered: RIGHT"
         **/
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement box = driver.findElement(By.id("target"));
        box.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).pause(1000).perform();
        element = driver.findElement(By.id("result"));

        assertEquals(element.getText(), "You entered: RIGHT", "Clicked right arrow key.");
    }

    @Test
    public void getCSSValue_quiz_5(){
        /*
         * go to https://ultimateqa.com/simple-html-elements-for-automation/
         * find element with text "Clickable Icon"
         * Assert href attribute =  https://ultimateqa.com/link-success/
         * Get CSS value: "background-origin"
         * Assert that it equals "padding-box"
         **/

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        WebElement linkText = driver.findElement(By.xpath("//a[normalize-space()='Clickable Icon']"));

        String link = linkText.getAttribute("href");
        assertEquals(link, "https://ultimateqa.com/link-success/");

     //   assertEquals(element.getCssValue("background-origin"), "padding-box");

    }
}
