package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementWithFindElements {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//stale element -- element not fresh
			driver = new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//			List<WebElement> footerList= driver.findElements(By.cssSelector("footer a"));
			List<WebElement> footerList= driver.findElements(By.xpath("//footer//a[@href]"));
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.pollingEvery(Duration.ofMillis(500))
//				.ignoring(StaleElementReferenceException.class)
//				.withMessage("Element not found...");
			
//			for(WebElement e: footerList) {
//				e.click();
//				driver.navigate().back();
//				//footerList= driver.findElements(By.cssSelector("footer a"));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("footer a")));
//			}
			
			for(int i=0;i<footerList.size();i++) {
				System.out.println(footerList.get(i).getText());
				footerList.get(i).click();
				Thread.sleep(1000);
				driver.navigate().back();
//				footerList= driver.findElements(By.cssSelector("footer a"));
				//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//footer//a[@href]")));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.pollingEvery(Duration.ofMillis(500))
					.ignoring(StaleElementReferenceException.class)
					.withMessage("Element not found...");
				//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//footer//a[@href]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//footer//a[@href]")));
			}

	}

}
