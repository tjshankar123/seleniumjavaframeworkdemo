package guru99.demoBank.POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import guru99.demoBank.PageFactory.Guru99HomePage;
import guru99.demoBank.PageFactory.Guru99Login;
import guru99.demoBank.PageFactory.Guru99NewCustomerPage;

public class Test99GuruLogin {

	
	WebDriver driver;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;
	Guru99NewCustomerPage objNewCutomerPage;

	@BeforeTest
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}
	
	@AfterTest
	public void tearup() {
		driver.quit();
	}

	/**
	 * This test case will login in http://demo.guru99.com/V4/ Verify login page
	 * title as guru99 bank Login to application Verify the home page using Dashboard message
	 */

	@Test(priority = 0)
	public void test_Home_Page_Appear_Correct() {

		// Create Login Page object
		objLogin = new Guru99Login(driver);

		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

		// login to application
		objLogin.loginToGuru99("mgr123", "mgr!23");

		// go the next page
		objHomePage = new Guru99HomePage(driver);

		// Verify home page
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

	}
	
	@Test(priority = 1)
	public void testNewCutomerPage() {
		objLogin = new Guru99Login(driver);
		objLogin.loginToGuru99("mgr123", "mgr!23");
		objHomePage = new Guru99HomePage(driver);
		objHomePage.clickNewCustomerLink();
		objNewCutomerPage = new Guru99NewCustomerPage(driver);
	}
}
