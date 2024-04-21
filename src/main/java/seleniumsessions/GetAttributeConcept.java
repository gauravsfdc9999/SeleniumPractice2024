package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetAttributeConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		//text --> getText()
		//attribute --> getAttribute()
		// get all the links
		//capture href values
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		//WebDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//		String fn_placeHolder = driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
//		System.out.println(fn_placeHolder);
		
		By firstName = By.id("input-firstname");
		By registerLink = By.linkText("Register");
		String fn_placeHolder = doElementGetAttribute(firstName, "placeholder");
		System.out.println(fn_placeHolder);
		String fn_class = doElementGetAttribute(firstName, "class");
		System.out.println(fn_class);
		
		String registerLink_href = doElementGetAttribute(registerLink, "href");
		System.out.println(registerLink_href);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static String doElementGetAttribute(By locator, String attributeValue) {
		return getElement(locator).getAttribute(attributeValue);
	}

}
