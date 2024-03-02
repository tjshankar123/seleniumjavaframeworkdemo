import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	@Test (enabled = false)
	public void WebDriverTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tjsha_lfek1mv\\Downloads\\chromedriver_79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		WebDriverManager.firefoxdriver().setup();
		
		// Create driver object for firefox browser.
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.toolsqa.com");
		System.out.println("WebDriverMangerTest :" + driver.getTitle());
		driver.quit();
		
	}

}
