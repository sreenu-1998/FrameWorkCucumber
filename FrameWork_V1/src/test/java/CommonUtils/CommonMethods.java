package CommonUtils;

	import java.io.IOException;
	import java.time.Duration;
	import java.util.List;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.NoAlertPresentException;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.TimeoutException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;



	
	public class CommonMethods extends Assertions {
		
		

		WebDriver driver = null;
		public CommonMethods(WebDriver driver) throws IOException{
			super(driver);
			this.driver = driver;	
		}



		
		/*Step to navigate to specified URL*/
		public void get(String url){
			driver.get(url);
		}


		/* method to navigate to specific page using url  */
		public void navigate(String url){
			driver.navigate().to(url);
		}

		/* method to click on an element using action class */
		public void clickOnElementUsingActions(By element){
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(element));
			actions.click().perform();
		}
			




		/* method to wait for an element to be visible */
		
		public boolean waitForVisibility(By targetElement) {
			try{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
				return true;
			}
			catch(TimeoutException e ){
				System.out.println("Element is not visible: " + targetElement );
				System.out.println();
				System.out.println(e.getMessage());
				throw new TimeoutException();

			}
		}

		/* method to wait for an element to be clickable
		 */
		public boolean waitForElementToBeClickable(By targetElement) {
			try{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(targetElement));
				return true;
			}
			catch(TimeoutException e ){
				System.out.println("Element is not clickable: " + targetElement );
				System.out.println();
				System.out.println(e.getMessage());
				throw new TimeoutException();

			}
		}



		
		public WebElement findElement(By locator){
			try {
				WebElement element = driver.findElement(locator);
				return element;
			}
			catch (NoSuchElementException e){
				throw new NoSuchElementException(e.getMessage());
			}
		}

		
		public List<WebElement> findElements(By locator){
			try {
				List<WebElement> element = driver.findElements(locator);
				return element;
			}
			catch (NoSuchElementException e){
				throw new NoSuchElementException(e.getMessage());
			}
		}

		
		
		public void acceptAlert(){
			try {
				Alert alert = driver.switchTo().alert(); 
				alert.accept();


			} catch (NoAlertPresentException e){
				throw new NoAlertPresentException();
			}	
		}


		
		public String getAlertText() 
		{ 
			try {
				Alert alert = driver.switchTo().alert(); 
				String alertText = alert.getText(); 
				return alertText; 
			} catch (NoAlertPresentException e){
				throw new NoAlertPresentException();
			}
		}   

		
		public boolean isAlertPresent() 
		{ 
			try 
			{ 
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert();
				return true; 
			}   
			catch (NoAlertPresentException e) 
			{   
				throw new NoAlertPresentException(); 
			}   
		}   
		public void ClickingElement(By targetLocator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(targetLocator)).click();

		}
		public void sendingKeys(By targetLocator, String string) {
			driver.findElement(targetLocator).sendKeys(string);
		}


				public void selectValuefromDropdownviaIndex(By selectLocator, int valueToBeSelectedindex){
			Select  selectFromDropdown = new Select(findElement(selectLocator));
			selectFromDropdown.selectByIndex(valueToBeSelectedindex);

		}
		public void selectValuefromDropdownviaValue(By selectLocator, String valueToBeSelected){
			Select  selectFromDropdown = new Select(findElement(selectLocator));
			selectFromDropdown.selectByVisibleText(valueToBeSelected);
		}
	}


