package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiLevelMenuhandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(3000);
		
		By shopByCategory = By.xpath("(//span[contains(text(),'Shop by')])[2]");
		By level1Menu = By.linkText("Beverages");
		By level2Menu = By.linkText("Tea");
		By level3Menu = By.linkText("Green Tea");
		handleMenuSubMenuLevel4(shopByCategory, level1Menu, level2Menu, level3Menu);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void handleMenuSubMenuLevel4(By shopByCategory, By level1Menu, By level2Menu, By level3Menu) throws InterruptedException {
		getElement(shopByCategory).click();
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		act.moveToElement(getElement(level1Menu)).build().perform();
		Thread.sleep(5000);
		act.moveToElement(getElement(level2Menu)).build().perform();
		Thread.sleep(5000);
		getElement(level3Menu).click();
	}

}
