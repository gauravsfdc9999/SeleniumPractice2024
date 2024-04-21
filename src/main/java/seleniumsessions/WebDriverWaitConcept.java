package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		//wait(Interface): Untill(abstract method);--> fluentWait(class): untill(){}+ other methods --> WebDriverWait(class): no methods
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		
		By fullName = By.id("Form_getForm_Name");
		By businessEmail = By.id("Form_getForm_Email");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement fullNameEle=wait.until(ExpectedConditions.presenceOfElementLocated(fullName)); //another way of creating webelement
//		fullNameEle.sendKeys("testing");
//		waitForElementPresence(fullName, 10).sendKeys("gaurav");
//		//waitForElementPresence(businessEmail, 2).sendKeys("test@gmail.com");
//		getElement(businessEmail).sendKeys("test@gmail.com");
		waitForElementVisible(fullName, 10).sendKeys("testing");
		
//		driver.findElement(By.id("Form_getForm_Email")).sendKeys("test@gmail.com"); //wait is not applied for this element

	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility means that 
	 * the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}

}
