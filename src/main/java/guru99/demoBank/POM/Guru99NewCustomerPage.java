package guru99.demoBank.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Guru99NewCustomerPage {
	
	WebDriver driver;
	@FindBy(xpath = "//p[@class='heading3']") 
	WebElement NewCustomerPageName;
	
	
	public Guru99NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getNewCustomerPageTitle() {
		return NewCustomerPageName.getText();
	}

}
