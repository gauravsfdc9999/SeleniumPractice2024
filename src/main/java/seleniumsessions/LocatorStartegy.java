package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorStartegy {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		//create a webelement + perform an action on it(click, sendkeys, gettext, isDisplayed)
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//1.Id : unique attributte: can not be duplicate - 1st preferred
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@1234");
		
		//2. name: can be duplicate - 2nd preferred
//		driver.findElement(By.name("firstname")).sendKeys("test1");
//		driver.findElement(By.name("lastname")).sendKeys("test2");
		
//		By fn = By.name("firstname");
//		By ln = By.name("lastname");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(fn, "test1");
//		eleUtil.doSendKeys(ln, "automation");
		
		// same way we can have string locators
		
		//3. class name locators : its not unique attribute and can be duplicate -- 3rd preferred
//		driver.findElement(By.className("form-control")).sendKeys("test1");
		
		//4.xpath its not an attribute. Its an address of specific element inside the HTML DOM. Its also called xml path
//		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("testing");
//		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("automation");
//		By fn = By.xpath("//*[@id=\"input-firstname\"]");
//		By ln = By.xpath("//*[@id=\\\"input-lastname\\\"]");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(fn, "test");
//		eleUtil.doSendKeys(ln, "automation");
		
		//5. CSS - cascading style sheet : its not an attribute
//		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("testing");
//		driver.findElement(By.cssSelector("#input-lastname")).sendKeys("automation");
		
		//6. linkText: only applicable for links : works for the text of the link
		//html dom <a> -- links
//		driver.findElement(By.linkText("Login")).click();
//		By loginLink = By.linkText("Login");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick(loginLink);
		
		//7. partial linktext : for the partial text of the link. But it should be unique and no other should have same partial text
//		driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8. tagName : html tags they are mostly not unique
//		String headerText = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(headerText);
		
		By pageHeader = By.tagName("h1");
		ElementUtil eleUtil = new ElementUtil(driver);
		System.out.println(eleUtil.doGetElementText(pageHeader));
	}

}
