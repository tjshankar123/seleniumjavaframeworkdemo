import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapablitiesDemo {

	public static void main(String[] args) {

		DesiredCapabilities caps = new DesiredCapabilities();

        caps.setPlatform(Platform.WINDOWS);
		caps.setCapability("ignoreProtectedModeSettings", true);

		
		
	}
}
