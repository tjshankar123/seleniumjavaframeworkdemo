package guru99.demoBank.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99HomePage {

	WebDriver driver;

	//@FindBy(xpath = "//table//tr[@class='heading3']")
	@FindBy(xpath = "//td[contains(text(),'Manger Id')]")
	WebElement homePageUserName;
	
	@FindBy(xpath = "//a[contains(text(),'New Customer')]") 
	WebElement NewCustomerPageName;

	public Guru99HomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	// Get the User name from Home Page
	public String getHomePageDashboardUserName() {
		System.out.println("homePageUserName.getText() is :" + homePageUserName.getText());
		return homePageUserName.getText();
	}
	
	public void clickNewCustomerLink() {
		NewCustomerPageName.click();
	}

}
