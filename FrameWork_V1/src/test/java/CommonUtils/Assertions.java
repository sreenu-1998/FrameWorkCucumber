package CommonUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * All the validation methods and method to take screenshot 
 * are defined in this class.
 */
public class Assertions {
	public boolean testCaseStatus = true;
	private WebDriver driver;
	private File file;
	private static String testScreenshotDir;
	boolean testStatus;

	public Assertions(WebDriver driver) {
		file = new File("");
		testScreenshotDir = file.getAbsoluteFile()
				+ "//src//test//java//outputFiles//";
		this.driver = driver;
		
	}
	public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
    public static ExtentReports extent ;
	public static void addScreenShotReport(String message) {
		try {
			extent = new ExtentReports();
			String screenshotPath = "screenshot" + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
					.format(new GregorianCalendar().getTime())
					+ ".png";
			ExtentTest test = extent.createTest("LoginTest", "Test Description");
			 File Screenshot = ((TakesScreenshot) WebDriverSession.getWebDriver()).getScreenshotAs(OutputType.FILE);
			 org.apache.commons.io.FileUtils.copyFile(Screenshot, new File(testScreenshotDir+ screenshotPath));
			test.log(Status.INFO, MarkupHelper.createLabel("Screenshot", ExtentColor.BLUE));
	        test.pass("Screenshot captured at the desired point", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        test.pass("Screenshot").addScreenCaptureFromPath(screenshotPath);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	method to take screenshot
	 */
	public String screenShot() {
		String screenshotPath = "screenshot" + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
		.format(new GregorianCalendar().getTime())
		+ ".png";

		System.out.println(screenshotPath);
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File( testScreenshotDir + screenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
			screenshotPath = "";
		}
		return screenshotPath;
	}
	
	/* Method to verify whether actual result is equal to expected result and take a screenshot if fails*/
	public boolean verifyEquals(Object actual, Object expected, String message, boolean screenshotOnFailure, boolean exitOnFailure) {
		testStatus=true;
		try {
			Assert.assertEquals(actual, expected, message);
			System.out.println("PASS "+message);

		} catch (AssertionError e) {
		
			testStatus = false; 
			
			if (screenshotOnFailure) {
			    System.out.println("FAIL "+message+ "Actual: "+actual+ "Expected: "+expected+ "Please check the screenshot" + "<a herf = '" +screenShot()+ "'></a>");

			} 

			if (exitOnFailure) {
				System.out.println("Exiting this function as exitOnFail flag is set to True. Will move to next test.");
				throw e;
			}
			
			System.out.println( "FAIL " + message + " Actual: "+ actual + " Expected: " + expected);

		}
		return testStatus;
	}

	
	/* This method is to Verify the given condition is True and take as Screenshot if fails	 */
	public boolean verifyTrue(boolean condition, String message,
			boolean screenshotOnFailure, boolean exitOnFailure) {
		try {
		
			Assert.assertTrue(condition, message);
			System.out.println("PASS" + message);
		
		} catch (AssertionError e) {
			this.testCaseStatus = false;
			
			
			if (screenshotOnFailure) {
				System.out.println( "FAIL" + message + " Actual: FALSE Expected: TRUE."
						+ " Please check the screenshot " +"<a href='" + screenShot()
							+ "'></a>" );

			} else {

				System.out.println("FAIL" + message);

			}

			if (exitOnFailure) {

				System.out.println("Exiting this function as exitOnFail flag is set to True.");
				throw e;

			}

		}

		return this.testCaseStatus;
	}
	

}

