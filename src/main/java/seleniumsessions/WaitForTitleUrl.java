package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {
	static WebDriver driver;
	public static void main(String[] args) {
		//waiting for non-webelement
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		long start = System.currentTimeMillis();
//		wait.until(ExpectedConditions.titleContains("Free CRM software for customer"));
//		long end = System.currentTimeMillis();
//		System.out.println("Page title: "+driver.getTitle());
//		System.out.println("time to get title: "+(end - start)+" milliseconds");
		long start = System.currentTimeMillis();
		String title = waitForTitleContains("Free CRM software for customer", (1/1000));
		long end = System.currentTimeMillis();
		System.out.println("Title" +title);
		System.out.println("time to get title: "+(end - start)+" milliseconds");
		
		driver.findElement(By.linkText("Sign Up")).click();
		String currentUrl = waitForUrlContains("register", 5);
		System.out.println("Current url is : "+currentUrl);
		
	}
	
	public static String waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
				return driver.getTitle();
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("title not found within: "+timeOut);
		}	
		return null;
	}
	
	public static String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("title not found within: "+timeOut);
		}	
		return null;
	}
	
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Url not found within: "+timeOut);
		}	
		return null;
	}
	
	public static String waitForUrlIs(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.urlToBe(url))) {
				return driver.getCurrentUrl();
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Url not found within: "+timeOut);
		}	
		return null;
	}

}
