import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.edgeDriver().setup();
	}

	@BeforeTest
	public void setupTest() {
		driver = new ChromeDriver();
		
		//driver = new FirefoxDriver();
		//driver = new edgeDriver();
	}

	@AfterTest
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() {
		driver.get("http://www.google.ca");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

}
