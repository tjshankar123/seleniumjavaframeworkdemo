import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapablitiesDemo {

	public static void main(String[] args) {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		
	}
}
