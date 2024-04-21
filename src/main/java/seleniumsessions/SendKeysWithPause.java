package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		//send keys with pause
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement search = driver.findElement(By.name("search"));
		
		String value = "macbook";
		//converting string to array of char
		char val[] = value.toCharArray();
		
		Actions act = new Actions(driver);
		
		for(char c: val) {
			act.sendKeys(search, String.valueOf(c)).pause(1000).build().perform();
		}
		
	}

}
