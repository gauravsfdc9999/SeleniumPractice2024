package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForIFramesConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By frameLocator = By.xpath("//iframe[contains(@id,'frame-one')]");
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator)); //returns driver
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
		waitForFrameAndSwitchToIt(frameLocator, 10);
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("gaurav");
		driver.switchTo().defaultContent();
		String veRegister = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(veRegister);
	}
	
	public static void waitForFrameAndSwitchToIt(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator)); //returns driver
	}

}
