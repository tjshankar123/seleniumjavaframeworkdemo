import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.gecko.driver", "C:/Users/tjsha_lfek1mv/eclipse-workspace1/SeleniumJavaFramework/drivers/geckodriver.exe");
		//String projectPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.ca");	
		
		System.out.println(driver.getTitle());		
		driver.close();
	}
}
