package WebPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;

import CommonUtils.CommonMethods;

public class LoginPage extends CommonMethods{
    WebDriver driver;
	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	//for common methods
	public By LP_USERNAME_TXTBOX1 = By.xpath("//*[@name = \"user-name\"]");
	public By LP_PASSWORD_TXTBOX1 = By.xpath("//*[@name = \"password\"]");
	public By LP_LOGIN_BTN1 = By.xpath("//*[@name = \"login-button\"]");

//	@FindBy(id = "user-name")
//	WebElement LP_USERNAME_TXTBOX;
//	
//	@FindBy(id = "password")
//	WebElement LP_PASSWORD_TXTBOX;
//	
//	@FindBy(id = "login-button")
//	WebElement LP_LOGIN_BTN;
//	
//	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[1]")
//	WebElement LP_LOGIN_LOGO;
	

public void enterUserName(String string) {
	driver.findElement(LP_USERNAME_TXTBOX1).sendKeys(string);
	
}
public void enterPassword(String string) {
	driver.findElement(LP_PASSWORD_TXTBOX1).sendKeys(string);
}
public void clickOnLogin() {
	driver.findElement(LP_LOGIN_BTN1).click();
}

}
