package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		//selenium 4.x has new methods for scrolling
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(1000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform(); //bottom of page
		Thread.sleep(2000);
		act.sendKeys(Keys.PAGE_UP).perform(); //scroll back to top of page
		
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform(); //using keyboard control+end
		Thread.sleep(1500);
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(1500);
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		
		//scroll to specific element and click
		WebElement scrollDelInfo = driver.findElement(By.xpath("//a[normalize-space()='Delivery Information']"));
		
		act.scrollToElement(scrollDelInfo)
			.click(scrollDelInfo)
				.build().perform();
		
		//Refresh from keyboard and driver.navigate.refresh
		Thread.sleep(1500);
		act.sendKeys(Keys.F5).perform();
			
		
	}

}
