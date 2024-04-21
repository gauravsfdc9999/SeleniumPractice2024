package seleniumsessions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWindow {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //parent
		driver.manage().window().maximize();
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("OrangeHRM"));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//p[text()='Username : Admin']"), 1));
//		String parentWindowId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[local-name()='svg' and @class='oxd-icon orangehrm-sm-icon']/parent::a[contains(@href,'linkedin')]")).click(); //child
		if(wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			Set<String> windowhandles = driver.getWindowHandles();
			Iterator<String> it = windowhandles.iterator();
			String parentWindowId = it.next();
			System.out.println("parent window is: "+parentWindowId);
			String childWindowHandle = it.next();
			System.out.println("child window is: "+childWindowHandle);
		}
		


	}
	
	public static boolean waitForWindowHandles(int totalNumberOfWindowsToBe, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.numberOfWindowsToBe(totalNumberOfWindowsToBe));
	}

}
