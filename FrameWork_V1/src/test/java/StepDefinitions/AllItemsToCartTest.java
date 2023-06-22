package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonUtils.Assertions;
import CommonUtils.CommonMethods;
import CommonUtils.WebDriverSession;
import Log.LoggerUtil;
import WebPages.CartPage;
import WebPages.HomePage;
import io.cucumber.java.en.*;

public class AllItemsToCartTest {
	CommonMethods cm;
	WebDriver driver;
	HomePage hp;
	CartPage cp;
	LoginTest lt;
	
	public AllItemsToCartTest() throws IOException {
		cm = new CommonMethods(driver);
		driver = WebDriverSession.getWebDriver();
		hp = new HomePage(driver);
		cp = new CartPage(driver);
		lt = new LoginTest();
		LoggerUtil.log("Test Case Started");
	}
	
	
	@Given("user logs in to application with valid credentials")
	public void user_logs_in_to_application_with_valid_credentials() throws InterruptedException {
		lt.user_enters_url("https://www.saucedemo.com/");
		lt.provides_and("standard_user", "secret_sauce");
		lt.user_clicks_login();
		lt.user_logins_in_successfully();
		Assertions.addScreenShotReport("Loged in");
	}

	@And("adds {int} to the cart.")
	public void adds_to_the_cart(Integer index) {
		//hp.AddtoCartItemByIndex(index);
		driver.findElement(By.xpath("//*[@class = \"inventory_list\"]/div["+index+"]/div[2]/div[2]/button")).click();
		Assertions.addScreenShotReport("Added Item to Cart");
		LoggerUtil.log("added item"+index+" cart");
	}

	@And("clicks on cart icon")
	public void clicks_on_cart_icon() {
		driver.findElement(hp.HP_SHOPPINGCART_BTN).click();
		Assertions.addScreenShotReport("Clicked on Shopping Cart");
		LoggerUtil.log("clicked on cart icon");
	}

	@And("clicks on checkout")
	public void clicks_on_checkout() {
		//cm.waitForElementToBeClickable(cp.CP_CheckOut_BTN);
		driver.findElement(cp.CP_CheckOut_BTN).click();
		Assertions.addScreenShotReport("Clicks on CheckOut");
		LoggerUtil.log("clicked on CheckOut");
	}

	@When("user provide {string} , {string} and {string}")
	public void user_provide_and(String string, String string2, String string3) {
		cp.enterDetailsInCheckOutPage(string, string2, string3);
		Assertions.addScreenShotReport("Enterd Deatils");
		LoggerUtil.log("Entered Deatils");
	}

	@And("clicks on Continue and Finish")
	public void clicks_on_continue_and_finish() {
		driver.findElement(cp.CP_Continue_BTN).click();
		//cm.waitForElementToBeClickable(cp.CP_Finish_BTN);
		driver.findElement(cp.CP_Finish_BTN).click();
		LoggerUtil.log("clicked on continue and finish");
	}

	@Then("Order is placed successfully")
	public void order_is_placed_successfully() {
		String expected = "Thank you for your order!";
		By actual = By.xpath("//h2[@class = \"complete-header\"]");
		//cm.waitForVisibility(actual);
		String actualS = driver.findElement(actual).getText();
		cm.verifyEquals(actualS, expected, actualS, false, false);
	}

}
