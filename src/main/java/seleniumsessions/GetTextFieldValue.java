package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFieldValue {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("victor@gmail.com");
		
		//getText() - can be applied where actual text is present. link, header, lablel, span
//		String email = driver.findElement(By.id("input-email")).getText();
//		System.out.println(email);
		
		//to fetch value that has been entered
		String emailValue = driver.findElement(By.id("input-email")).getAttribute("value");
		System.out.println(emailValue);
		
		driver.close();
		

	}

}
