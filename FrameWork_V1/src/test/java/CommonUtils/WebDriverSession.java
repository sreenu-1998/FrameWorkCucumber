package CommonUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSession {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>(); 

	
	@Before
	public static void createDriver() {

		String browserName = "chrome";


		DesiredCapabilities capability = new DesiredCapabilities();

		
		 if(browserName.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			capability.setBrowserName("Firefox");
			webDriver.set(new FirefoxDriver());

		}else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			capability.setBrowserName("Edge");
			webDriver.set(new EdgeDriver());
		}else if(browserName.equalsIgnoreCase("Internet Explorer")){
			WebDriverManager.iedriver().setup();
			capability.setBrowserName("Internet Explorer");
			webDriver.set(new InternetExplorerDriver());
		}
		
		else if(browserName.equalsIgnoreCase("chrome")){
			String OS = System.getProperty("os.name");
			if(OS.contains("Windows"))
			{
				WebDriverManager.chromedriver().setup();
				capability.setBrowserName("Chrome");
				capability.setPlatform(Platform.WIN8_1);
				webDriver.set(new ChromeDriver());
			}
			else if(OS.contains("Linux"))
			{
				WebDriverManager.chromedriver().setup();
				capability.setBrowserName("Chrome");
				capability.setPlatform(Platform.LINUX);
				webDriver.set(new ChromeDriver());
			}
			else if(OS.contains("Mac"))
			{
				WebDriverManager.chromedriver().setup();
				capability.setBrowserName("Chrome");
				capability.setPlatform(Platform.MAC);
				webDriver.set(new ChromeDriver());
			}
		}
		getWebDriver().manage().window().maximize();

	}




	
	public static WebDriver getWebDriver() {
		System.out.println("WebDriver: " + webDriver.get());
		return webDriver.get();

	}

	
	@After
	public void teardown(Scenario scenario){

		// Here will compare if test is failing then only it will enter into if condition

		if(scenario.isFailed())
		{
			try 
			{
				
				TakesScreenshot ts=(TakesScreenshot) getWebDriver();

				
				File source=ts.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(source, new File(".//src//test//java//FailedScreenshots//"+ "FailScreenshot" + 
						new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss")
						.format(new GregorianCalendar().getTime())
						+ ".png"));
			} 
			catch (Exception e)
			{

				System.out.println("Exception while taking Screenshot");

			}
		}
		
		System.out.println("\n");
		getWebDriver().quit();
	}
}
