import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class   SeleniumTest {
	static WebDriver driver;


	@Test (enabled = false)
	public void WebDriverTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tjsha_lfek1mv\\Downloads\\chromedriver_79\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.toolsqa.com");
		System.out.println("WebDriverTest :" + driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void WebDriverMangerTest() {
		// WebDriverManager is automating the webdriver binary management.
		// It download the required driver binary file (if not present locally) in the cache (~/.m2/repository/webdriver)
		// It eliminate the problem of locally storing the driver binary.
		
		// Setup the chrome driver using WebDriverManager.
		WebDriverManager.chromedriver().setup();
		
		// Create driver object for firefox browser.
		driver = new ChromeDriver();
		driver.get("http://www.toolsqa.com");
		System.out.println("WebDriverMangerTest :" + driver.getTitle());

		
	}

	@Test
	public void navigationTest(){
		// Setup the chrome driver using WebDriverManager.
		WebDriverManager.chromedriver().setup();

		// Create driver object for firefox browser.
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.ca");
		System.out.println("Navigation Test :" + driver.getTitle());

		driver.findElement(By.xpath("//a[normalize-space()='Gmail']")).click();
		System.out.println("Navigation Test :" + driver.getTitle());

		driver.navigate().back();
		System.out.println("Navigation back Test :" + driver.getTitle());

		driver.navigate().forward();
		System.out.println("Navigation forward Test :" + driver.getTitle());

		driver.navigate().refresh();
		System.out.println("Navigation refresh Test :" + driver.getTitle());

	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
