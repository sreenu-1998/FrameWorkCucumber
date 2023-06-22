package WebPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import CommonUtils.CommonMethods;

public class HomePage extends CommonMethods{

	public HomePage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}
	/*@FindBy(how = How.XPATH, using = "//button[@class = 'btn btn_primary btn_small btn_inventory']")*/
	public By HP_AddToCart_BTN = By.xpath("\"//button[@class = 'btn btn_primary btn_small btn_inventory']");
	
	/*@FindBy(how = How.XPATH, using = "//div[@class = \"inventory_item_name\"]")*/
	public By HP_ItemName_LNK = By.xpath("//div[@class = 'inventory_item_name']");
	
	/*@FindBy(how = How.XPATH, using = "//div[@class = \"inventory_item_price\"]")*/
	public By HP_ItemPrice_LNK = By.xpath("//div[@class = 'inventory_item_price']");
	
	@FindBy(how = How.XPATH, using = "//div[@class = 'app_logo']")
	public WebElement HP_LOGO;
	
	//@FindBy(id = "shopping_cart_container")
	public By HP_SHOPPINGCART_BTN = By.id("shopping_cart_container");
	
	@FindBy(id = "react-burger-menu-btn")
	public WebElement HP_MENU_BTN;
	
	@FindBy(id = "inventory_sidebar_link")
	public WebElement HP_InventorySideBar_LNK;
	
	@FindBy(id = "about_sidebar_link")
	public WebElement HP_AboutSideBar_LNK;
	
	@FindBy(id = "logout_sidebar_link")
	public WebElement HP_LogOutSideBar_LNK;
	
	@FindBy(id = "reset_sidebar_link")
	public WebElement HP_ResetSideBar_LNK;
	
	@FindBy(how = How.XPATH, using = "//select[@class = 'product_sort_container']")
	public WebElement HP_Filter_DD;
	
	public void AddtoCartItemByIndex(Integer index) {
		waitForElementToBeClickable(HP_AddToCart_BTN);
		driver.findElements(HP_AddToCart_BTN).get(index).click();
		List<WebElement> s = driver.findElements(HP_AddToCart_BTN);
		System.out.println(s.get(index));
	}
	public void selectItemByIndex(Integer index) {
		driver.findElements(HP_AddToCart_BTN).get(index).click();
	}
	

}
