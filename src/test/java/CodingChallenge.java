import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;



public class CodingChallenge {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        CodingChallenge test1 = new CodingChallenge();
        //test1.dynamicElement_viaAI(driver);
        test1.dynamicElement_naveenAutomation(driver);


    }

    public void dynamicElement_viaAI(WebDriver driver) throws InterruptedException {

        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

    public void dynamicElement_naveenAutomation(WebDriver driver) throws InterruptedException {
        /*  keep getting the count of
            - Current world population
            - Today : Births, Deaths and population growth today.
            - This year: Births, Deaths and population growth today.
        */

        int count = 0;

        String xpath_currentPopulation = "//div[@class='text-center text-4xl font-bold text-zinc-500 md:text-6xl']/span[@class='rts-counter']";
        String xpath_todayPopulation = "//span[@rel='births_today']";
        String xpath_thisYearPopulation = "//span[@rel='births_this_year']";

        String xpath_today_thiYearPopulation = "//span[@rel='births_today' or @rel='births_this_year']";

        driver.get("https://www.worldometers.info/world-population/");
        driver.manage().window().maximize();

        while (count < 20) {
            printPopulationData(xpath_currentPopulation);
            //  printPopulationData(xpath_todayPopulation);
            //  printPopulationData(xpath_thisYearPopulation);
            printPopulationData(xpath_today_thiYearPopulation);
            System.out.println((count+1) +":" + "==============================================");
            count ++;
            Thread.sleep(1000);
        }

        //driver.close();
        driver.quit();
    }

    public void printPopulationData(String locator) throws InterruptedException {

            List<WebElement> popList = driver.findElements(By.xpath(locator));

            for (WebElement e: popList) {
                System.out.println(e.getText());
            }

    }

    

}
