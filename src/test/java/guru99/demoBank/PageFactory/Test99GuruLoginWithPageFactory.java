package guru99.demoBank.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test99GuruLoginWithPageFactory {

	//String driverPath = "C:\\geckodriver.exe";

	WebDriver driver;
	Guru99Login objLogin;
	Guru99HomePage objHomePage;
	Guru99NewCustomerPage objNewCutomerPage;

	@BeforeMethod
	public void setup() {		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://demo.guru99.com/V4/");
	}
	
	@AfterMethod
	public void tearup() {

		driver.close();
	}

	/**
	 * This test go to http://demo.guru99.com/V4/ Verify login page title as guru99
	 * bank Login to application Verify the home page using Dashboard message
	 */

	@Test(enabled = true)
	public void test_Home_Page_Appear_Correct() {

		// Create Login Page object
		objLogin = new Guru99Login(driver);

		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitle();
		System.out.println("loginPageTitle" + loginPageTitle);
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

		// login to application
		objLogin.loginToGuru99("mgr123", "mgr!23");

		// go the next page
		objHomePage = new Guru99HomePage(driver);

		// Verify home page
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));	
	
	}
	
	@Test(enabled = true)
	public void testNewCutomerPage() {
		objLogin = new Guru99Login(driver);
		objLogin.loginToGuru99("mgr123", "mgr!23");
		objHomePage = new Guru99HomePage(driver);
		objHomePage.clickNewCustomerLink();
		objNewCutomerPage = new Guru99NewCustomerPage(driver);
		
	}

}
