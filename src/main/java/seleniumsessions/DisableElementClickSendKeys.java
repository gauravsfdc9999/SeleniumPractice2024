package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisableElementClickSendKeys {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
//		driver.findElement(By.linkText("Sign Up")).click();
//		String currentPageUrl = driver.getCurrentUrl();
//		String currentPageHandle = driver.getWindowHandle();
//		System.out.println("Current page url: "+currentPageUrl);
//		System.out.println("Current page handle: "+currentPageHandle);
		
//		driver.findElement(By.id("pass")).click();
//		driver.findElement(By.id("pass")).sendKeys("somtvalue"); //org.openqa.selenium.ElementNotInteractableException: element not interactable
		
//		driver.findElement(By.id("fname")).sendKeys(null); //java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
		
		StringBuilder sb = new StringBuilder("testing");
		String s =" automation";
		//driver.findElement(By.id("fname")).sendKeys(sb+s);
		driver.findElement(By.id("fname")).sendKeys(sb,s," gaurav", " gupta");
		
		//CharSequence -- interface and 
		//String, SBuilder, SBuffer are child
		
//		driver.close();

	}

}
