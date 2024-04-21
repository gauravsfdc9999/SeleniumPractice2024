package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcepts {
	static WebDriver driver;
	public static void main(String[] args) {
		//wait(Interface): Untill(abstract method);--> FluentWait(class): untill(){}+ other methods --> WebDriverWait(class): no methods
		
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		//driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
		By imageSelector = By.cssSelector("div#imageTemplateContainer img");
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//								.withTimeout(Duration.ofSeconds(10))
//								.pollingEvery(Duration.ofSeconds(2))
//								.ignoring(NoSuchElementException.class)
//								.withMessage("time out.. element is not present.....");
//		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(imageSelector));
//		imageElement.click();
		
		//WebDriver wait with FluentWait features - 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class)
			.withMessage("time out.. element not present...");
		WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(imageSelector));
		imageElement.click();
		
	}

}
