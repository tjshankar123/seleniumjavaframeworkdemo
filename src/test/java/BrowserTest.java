import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BrowserTest {
	public static void main(String[] args) {

		String url = "https://demo.guru99.com/test/newtours/register.php";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.get("http://www.google.ca");
		driver.navigate().to("http://www.google.ca");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement element = driver.findElement(By.xpath("(//input[@name='btnI'])[2]"));
		System.out.println(element.getAttribute("value"));
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(url);
		Select dropdownCountry = new Select(driver.findElement(By.name("country")));
		dropdownCountry.selectByVisibleText("ANTARCTICA");
		System.out.println(dropdownCountry.getFirstSelectedOption().getText());

		dropdownCountry.selectByIndex(10);
		System.out.println(dropdownCountry.getFirstSelectedOption().getText());
		driver.close();
	}
}
