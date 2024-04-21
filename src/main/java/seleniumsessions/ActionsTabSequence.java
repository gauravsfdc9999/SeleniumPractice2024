package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabSequence {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		//tab keys with pause to fill form
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement fName = driver.findElement(By.name("firstname"));
		
		Actions act = new Actions(driver);
		act.sendKeys(fName, "gaurav")
			.sendKeys(Keys.TAB)
			.pause(1000)
			.sendKeys("lastname")
			.sendKeys(Keys.TAB)
			.pause(1000)
			.sendKeys("gaurav@gmail.com")
			.sendKeys(Keys.TAB)
			.pause(1000)
			.sendKeys("99999999")
			.sendKeys(Keys.TAB)
			.pause(1000)
			.sendKeys("some@123")
			.sendKeys(Keys.TAB)
			.pause(1000)
			.sendKeys("some@123")
			.build().perform();
		
		
	}

}
