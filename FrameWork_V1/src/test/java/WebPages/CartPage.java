package WebPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonUtils.CommonMethods;

public class CartPage extends CommonMethods{

	public CartPage(WebDriver driver) throws IOException {
		super(driver);
	}
	/*@FindBy(how = How.XPATH, using = "//div[@class = \"inventory_item_name\"]")*/
	public By CP_ItemsInCart = By.xpath("//div[@class = 'inventory_item_name']");
	
	@FindBy(how = How.XPATH, using = "//button[@class = \"btn btn_secondary btn_small cart_button\"]")
	public List<WebElement> CP_ItemRemove_BTN;
	
	/*@FindBy(how = How.XPATH, using = "//button[@class = \"btn btn_action btn_medium checkout_button\"]")*/
	public By CP_CheckOut_BTN = By.xpath("//button[@class = 'btn btn_action btn_medium checkout_button']");
	
	/*@FindBy(how = How.XPATH, using = "//button[@class = \"btn btn_secondary back btn_medium\"]")*/
	public By CP_ContinueShopping_BTN = By.xpath("//button[@class = 'btn btn_secondary back btn_medium']");
	
	//CheckOutPage Elements
	
	//@FindBy(id = "first-name")
	public By CP_FirstName_TXT = By.xpath("//*[@id = 'first-name']");
	
	///@FindBy(id = "last-name")
	public By CP_LastName_TXT = By.xpath("//*[@id = 'last-name']");
	
	//@FindBy(id = "postal-code")
	public By CP_PostalCode_TXT = By.xpath("//*[@id = 'postal-code']");
	
	//@FindBy(id = "continue")
	public By CP_Continue_BTN = By.id("continue");

	//@FindBy(id = "finish")
	public By CP_Finish_BTN = By.id("finish");
	
	public void enterDetailsInCheckOutPage(String firstN, String lastN, String pin) {
		driver.findElement(CP_FirstName_TXT).sendKeys(firstN);
		driver.findElement(CP_LastName_TXT).sendKeys(lastN);
		driver.findElement(CP_PostalCode_TXT).sendKeys(pin);
	}

}
