package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");
//		WebElement content = driver.findElement(By.cssSelector("a.menulink"));
//		
//		Actions act = new Actions(driver);
//		////ul[@class='submenu']//a[contains(text(),'Articles')]
//		//act.moveToElement(content).perform();
//		//or
//		act.moveToElement(content).build().perform();
//		Thread.sleep(3000);
//		
//		driver.findElement(By.linkText("ARTICLES")).click();
		
		By parentLocator = By.cssSelector("a.menulink");
		By subMenu = By.linkText("ARTICLES");
		handleMenuSubMenuLevel2(parentLocator, subMenu);
		Thread.sleep(5000);
		int totalLinks = driver.findElements(By.cssSelector("div.box_content_result > div:nth-of-type(n+1)")).size();
		if(totalLinks>0) {
			System.out.println("Test passed");
		}
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		By parentLocatorSJ = By.xpath("//div[contains(text(),'Add-ons')]");
		//By subMenulocatorSJ = By.xpath("//div[contains(text(),'Visa Services') and normalize-space()='Visa Services' and @dir='auto']");
		By subMenulocatorSJ = By.xpath("//div[text()='Visa Services']");
		handleMenuSubMenuLevel2(parentLocatorSJ, subMenulocatorSJ);
		
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void handleMenuSubMenuLevel2(By parentLocator, By SubMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentLocator)).build().perform();
		Thread.sleep(5000);
		getElement(SubMenuLocator).click();
	}

}
