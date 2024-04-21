package seleniumsessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	static WebDriver driver ;
	public static void main(String[] args) {
		
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		//create a webelement + perform an action on it(click, sendkeys, gettext, isDisplayed)
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//1.Approach
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@1234");
		
		//2. Approach
//		WebElement emailID = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailID.sendKeys("test@gmail.com");
//		password.sendKeys("test@1234");
		
		//3. Approach - By Locator
//		By userName = By.id("input-email");
//		By pswd = By.id("input-password");
//		WebElement emailID = driver.findElement(userName);
//		WebElement password = driver.findElement(pswd);
//		emailID.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
		//4. By locator with some utility
//		By userName = By.id("input-email");
//		By pswd = By.id("input-password");
//		WebElement emailID = getElement(userName);
//		WebElement password = getElement(pswd);
//		
//		//action
//		emailID.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
		//5. Aproach
//		By userName = By.id("input-email");
//		By pswd = By.id("input-password");
//		boolean userNameDisplayed=getElement(userName).isDisplayed();
//		if(userNameDisplayed) {
//			doSendKeys(userName, "test@gmail.com");
//			System.out.println("entering username values");
//		}
//		else {
//			System.out.println("username is not displayed");
//		}
//		
//		doSendKeys(pswd, "test@123");
		
		//6.Approach By locator and create a common utility class for elements. most preferred
		By userName = By.id("input-email");
		By pswd = By.id("input-password");
//		boolean userNameDisplayed=getElement(userName).isDisplayed();
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(userName, "test@gmail.com");
		eleUtil.doSendKeys(pswd, "test@123");
		
		//7. BrUtil+ eleUtil
		
		//8. Create utility for By -- String locators--used for smaller/mid size project
		String userID = "input-email";
		String passwordID = "input-password";
		
		eleUtil.doSendKeys("id", userID, "gg@gmail.com");
		eleUtil.doSendKeys("id", passwordID, "gg@1234");
		
		//String --> by --> webelement -- action
		//by --> webelement --> action --1st preference
		//webelement -- action -- 3rd
		
	}
	
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//		
//	}
//	
//	public static void doSendKeys(By locator,String value) {
//		getElement(locator).sendKeys(value);
//	}

}
