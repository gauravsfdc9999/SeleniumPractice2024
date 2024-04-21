package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectBasedDropDown {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		
//		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		//using select class only available for select class
//		Select select = new Select(country);
		
		//select has 3 methods selectByIndex, selectbyVisibleText, selectByValue
		
//		select.selectByIndex(5); //index are likely to change
//		select.selectByVisibleText("India");//Text will remain same
//		select.selectByValue("Australia"); //if attribute value is available
		
		//creating utility
		By country = By.id("Form_getForm_Country");
		doSelectByIndex(country, 5);
		doSelectByValue(country, "india"); //NoSuchElementException:
		doSelectByVisibleText(country, "Australia");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectByVisibleText(By locator, String visibleText) {
		if(visibleText!=null || visibleText.length()!=0) {
			Select select = new Select(getElement(locator));
			select.selectByVisibleText(visibleText);
		}
		else {
			throw new MyElementException("Text cannot be null");
		}

	}
	
	public static void doSelectByValue(By locator, String attrValue) {
		if(attrValue!=null || attrValue.length()!=0) {
			Select select = new Select(getElement(locator));
			select.selectByValue(attrValue);
		}
		else {
			throw new MyElementException("Attribute value cannot be null");
		}
		

	}

}
