package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import CommonUtils.Assertions;
import CommonUtils.CommonMethods;
import CommonUtils.WebDriverSession;
import Log.LoggerUtil;
import WebPages.LoginPage;
import io.cucumber.java.en.*;

public class LoginTest {
	WebDriver driver; 
	 CommonMethods cm; 
	 LoginPage lp; 
	
	
	public LoginTest() throws IOException {
		driver = WebDriverSession.getWebDriver();
		cm = new CommonMethods(driver);
		lp = new LoginPage(driver);
		LoggerUtil.log("Test Case Started");
		
	}

	@Given("user enters url {string}")
	public void user_enters_url(String string) {
		LoggerUtil.log("User Enters Url");
		cm.get(string);
		Assertions.addScreenShotReport("Enters Url");
	}

	@And("provides {string} and {string}")
	public void provides_and(String string, String string2) throws InterruptedException {
		cm.waitForVisibility(lp.LP_USERNAME_TXTBOX1);
		LoggerUtil.log("User Enters UserName");
		lp.enterUserName(string);
		Thread.sleep(2000);
		LoggerUtil.log("User Enters Password");
		lp.enterPassword(string2);
		Assertions.addScreenShotReport("Enters Username and Password");
		
	}

	@When("user clicks login")
	public void user_clicks_login() throws InterruptedException {
		Thread.sleep(2000);
		LoggerUtil.log("User Clicks Login");
		lp.clickOnLogin();
		Assertions.addScreenShotReport("Clicks Login");
		
	}

	@Then("user logins in successfully")
	public void user_logins_in_successfully() throws InterruptedException {
		String actual = driver.getTitle();
		String expected = "Swag Labs";
	    cm.verifyEquals(actual, expected, "This is to verify the page title", true, false);
		System.out.println(actual);
		Thread.sleep(2000);
		Assertions.addScreenShotReport("HomePage");
		LoggerUtil.log("Test Case End");
	}


}
