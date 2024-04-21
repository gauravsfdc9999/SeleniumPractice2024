package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementRefExceptionConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		//stale element -- element not fresh
			driver = new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
			WebElement emailId = driver.findElement(By.id("input-email")); 
			//f.0D9193AB27E026D65471238B79A5276E.d.189C946BAF67D65A7AADB7F0FE8C5EB2.e.4
			emailId.sendKeys("test11@gmail.com");
			driver.navigate().refresh(); //DOM is refreshed which gives refreshed DOM
			//emailId = driver.findElement(By.id("input-email")); //to avoid stale element reinitialize the webelement value
			//f.0D9193AB27E026D65471238B79A5276E.d.74DADA4BF552CB99A869891DA70798A0.e.45
			//emailId.sendKeys("tom@gmail.com");
			//stale element means element id is expired and hence it has to be re-initialize the webelement
			
			//other case to resolved stale element
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.pollingEvery(Duration.ofMillis(500))
				.ignoring(StaleElementReferenceException.class)
				.withMessage("Element not found...");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys("tom@gmail.com");

	}
}
