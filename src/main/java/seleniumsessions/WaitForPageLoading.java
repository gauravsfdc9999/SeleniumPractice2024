package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoading {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		if(!isPageLoaded(5)) {
			throw new BrowserException("page not loaded in 10 seconds");
		}
		
		
	}
	
	public static boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("document.readyState === 'complete'")).toString();
		return Boolean.parseBoolean(flag);
		
	}

}
