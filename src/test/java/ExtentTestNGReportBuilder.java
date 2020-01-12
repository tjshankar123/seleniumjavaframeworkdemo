import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestNGReportBuilder {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		
		// Create a extentReport and attach with htmlReporter.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
		
	}
	
	@AfterSuite
	public void teatDown() {
		extent.flush();		
	}
	
	@Test
	public void test1() throws Exception {
		
		// Create a toggle for the given test, adds all the logs events under it.
		ExtentTest test = extent.createTest("MyFirstTest", "Sample Description");
		
		test.log(Status.INFO, "This steps shows log(INFO, detals)");
		
		test.log(Status.DEBUG, "This steps shows log(DEBUG, detals)");
		test.log(Status.ERROR, "This steps shows log(ERROR, detals)");
		test.log(Status.FAIL, "This steps shows log(FAIL, detals)");
		test.log(Status.FATAL, "This steps shows log(FATAL, detals)");
		test.log(Status.PASS, "This steps shows log(PASS, detals)");
		test.fatal("This steps shows FATAL");
		test.pass("This steps shows PASS");
		test.log(Status.SKIP, "This steps shows log(SKIP, detals)");
		test.log(Status.WARNING, "This steps shows log(WARNING, detals)");
		
	}

}
