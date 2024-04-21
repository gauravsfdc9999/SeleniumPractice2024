package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CustomWaitConcept {
	static WebDriver driver;
	
	public static WebElement retryingElement(By locator, int numberOfAttempts) {
		WebElement element= null;
		int attempts = 0;
		
		while(attempts < numberOfAttempts) {
			try {
				element = driver.findElement(locator);
				System.out.println("element found in... "+locator+" in attempts "+attempts);
				break;
			}catch(NoSuchElementException ex) {
				System.out.println("Element not found..."+" in attempts "+attempts);
				try {
					Thread.sleep(Duration.ofMillis(500));
				}catch (InterruptedException en) {
					en.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null) {
			System.out.println("element not found.. tried for "+numberOfAttempts+" times with default interval time 500 milliseconds");
			throw new MyElementException("element not found.. tried with default interval time 500 milliseconds");
		}
		return element;	
	}
	
	public static WebElement retryingElement(By locator, int numberOfAttempts, int intervalTime) {
		WebElement element= null;
		int attempts = 0;
		
		while(attempts < numberOfAttempts) {
			try {
				element = driver.findElement(locator);
				System.out.println("element found in... "+locator+" in attempts "+attempts);
				break;
			}catch(NoSuchElementException ex) {
				System.out.println("Element not found..."+" in attempts "+attempts);
				try {
					Thread.sleep(Duration.ofMillis(intervalTime*1000));
				}catch (InterruptedException en) {
					en.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null) {
			System.out.println("element not found.. tried for "+numberOfAttempts+" times with interval time " + intervalTime+" seconds");
			throw new MyElementException("element not found.. tried with default given interval time");
		}
		return element;	
	}
	
//	public static WebElement retryingElementTime(By locator, long timeOut, int intervalTime) {
//		WebElement element= null;
//		int attempts = 0;
//		long currentTime = System.currentTimeMillis();
//		long seconds = TimeUnit.MILLISECONDS.toSeconds(currentTime);
//		System.out.println("time in seconds "+seconds);
//		timeOut=currentTime+(timeOut*1000);
//		
//		while(currentTime < timeOut) {
//			try {
//				element = driver.findElement(locator);
//				System.out.println("element found in... "+locator+" in time "+(currentTime/1000)+" seconds");
//				break;
//			}catch(NoSuchElementException ex) {
//				System.out.println("Element not found..."+" in attempts "+(currentTime/1000)+" seconds");
//				try {
//					Thread.sleep(Duration.ofMillis(intervalTime*1000));
//				}catch (InterruptedException en) {
//					en.printStackTrace();
//				}
//			}
//			currentTime+=(intervalTime*1000);
//		}
//		if(element==null) {
//			System.out.println("element not found.. tried for "+(currentTime/1000)+" seconds with interval time " + intervalTime+" seconds");
//			throw new MyElementException("element not found.. tried with default given interval time");
//		}
//		return element;	
//	}
	
	public static void main(String[] args) {
		//Thread.sleep --- static wait --> dynamic wait
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By emailId = By.id("input-email");
		//retryingElement(emailId, 5).sendKeys("test@gmail.com");
		//retryingElement(emailId, 5, 2).sendKeys("test@gmail.com");
		
	}

}
