import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().version("2.36").setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.ca");
		System.out.println(driver.getTitle());
		
		driver.close();

	}

}
