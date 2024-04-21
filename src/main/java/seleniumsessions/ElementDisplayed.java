package seleniumsessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplayed {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//isDisplayed is not good to use as if element is not present then we will get no such element exception
//		boolean flag = driver.findElement(By.className("img-responsive11")).isDisplayed();
//		By logo = By.className("img-responsive");
//		if(isElementDisplayed(logo)) {
//			System.out.println("logo is displayed");
//		}
//		else {
//			System.out.println("logo is NOT displayed");
//		}
		
//		List<WebElement> logoList = driver.findElements(By.className("img-responsive"));
//		if(logoList.size()==1) {
//			System.out.println("logo is displayed");
//		}
//		else {
//			System.out.println("logo is NOT displayed");
//		}
		By logo = By.className("img-responsive");
		if(isElementExists(logo)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("False");
		}
		driver.close();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static boolean isElementExists(By locator) {
		if(getElements(locator).size()==1) {
			return true;
		}
		else {
			return false;
		}
	}

}
