package AccessibilityTest;

import freemarker.template.TemplateException;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sridharbandi.AxeRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class AXERunnerDemo {
    private WebDriver driver;
    private static AxeRunner axeRunner;

    @BeforeEach
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().fullscreen();
        axeRunner = new AxeRunner(driver);
    }

    @AfterEach
    public void tearDown() throws IOException, TemplateException, URISyntaxException {
        axeRunner.execute();
        driver.quit();
    }


    @AfterAll
    public static void generateReport() throws IOException {
        axeRunner.generateHtmlReport();
    }

    @Test
    public void googleTest() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void stockTest() {
        driver.get("https://www.istockphoto.com/");
    }
}
