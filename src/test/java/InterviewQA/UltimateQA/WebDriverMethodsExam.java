package InterviewQA.UltimateQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.mozilla.javascript.JavaScriptException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WebDriverMethodsExam {

    WebDriver driver;
    WebElement element;
    private JavascriptExecutor javascriptExecutor;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void actionsTest(){
        /*
         * 1. Open url https://example.cypress.io/commands/actions
         * 2. Focus on element By.CssSelector(".action-focus")
         * 3. Assert is focused.
         */

        driver.get("https://example.cypress.io/commands/actions");
        element = driver.findElement(By.cssSelector(".action-focus"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        assertTrue(driver.findElement(By.xpath("//*[@for='password1']"))
                            .getAttribute("style")
                            .contains("color: orange"));

    }

    @Test
    public void cookiesTest(){
        /*
         * 1. Go to https://example.cypress.io/commands/cookies
         * 2. Set a cookie using button
         * 3. Get the cookie named "token"
         * 4. Assert that we have a cookie value equal to "123ABC"
         */

        driver.get("https://example.cypress.io/commands/cookies");
        element = driver.findElement(By.xpath("//div[@id='getCookie']//button[contains(@class,'set-a-cookie')]"));
        element.click();

        //Retrive the cookie
        var cookie = driver.manage().getCookieNamed("token");
        assertEquals("123ABC", cookie.getValue());
        assertTrue(cookie.getValue().equals("123ABC"));
    }

    @Test
    public void scrollToBottomTest() throws InterruptedException {
        /*
         * 1. Go to https://ultimateqa.com/complicated-page/
         * 2. scroll to bottom of the page using 'JS executeScript' command.
         *    eg: window.scrollTo(0, document.body.scrollHeight)
         *        Thread.sleep(1000)
         */

        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeAsyncScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    @Test
    public void scrollToTop() throws InterruptedException {
        /*
         * 1. Go to https://ultimateqa.com/complicated-page/
         * 2. scroll to top of the page using 'JS executeScript' command.
         *    eg: window.scrollTo(0, document.body.scrollHeight)
         *        Thread.sleep(1000)
         */

        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeAsyncScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        // Now scroll to the top.
        javascriptExecutor.executeAsyncScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(1000);

    }

    @Test
    public void howToHighlightTest(){

    }


}
