import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SampleExtentReport {

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		
		// Create a extentReport and attach with htmlReporter.
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		// Create a toggle for the given test, adds all the logs events under it.
		ExtentTest test = extent.createTest("MyFirstTest", "Sample Description");
		
		test.log(Status.INFO, "This steps shows log(INFO, detals)");
		
		test.log(Status.DEBUG, "This steps shows log(DEBUG, detals)");
		test.log(Status.ERROR, "This steps shows log(ERROR, detals)");
		test.log(Status.FAIL, "This steps shows log(FAIL, detals)");
		test.log(Status.FATAL, "This steps shows log(FATAL, detals)");
		test.log(Status.PASS, "This steps shows log(PASS, detals)");
		test.log(Status.SKIP, "This steps shows log(SKIP, detals)");
		test.log(Status.WARNING, "This steps shows log(WARNING, detals)");
		
		
		try {
			test.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.flush();

	}

}
