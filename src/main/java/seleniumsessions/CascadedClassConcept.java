package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CascadedClassConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().window().maximize();
		
		//InvalidSelectorException: compound class names are not permitted
//		driver.findElement(By.className("uiButton private-button private-button--primary private-button--default m-bottom-4 login-submit private-button--non-link")).sendKeys("gauravg@gmail.com");
		
		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("test");
		
		//NSE
//		driver.findElement(By.xpath("//input[@class='login-email']")).sendKeys("test");
		
		//driver.findElement(By.xpath("//input[contains(@class,'login-email')]")).sendKeys("test");
		//valid
		//driver.findelement(By.cssSelector("input[class='form-control private-form__control login-password m-bottom-3']"));
		
		//to check if class name is unique or not use -- .classname
		driver.findElement(By.className("login-email")).sendKeys("test");
		

		
		

	}

}
