package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlerts {

	static WebDriver driver;
	public static void main(String[] args) {
		//popup
		//alert
		//confirmation
		//prompt
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1.
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //wait for alert and switch to alert
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		alert.accept();
		//waitForJSAlert(5);
		System.out.println(getAlertText(5));
		acceptAlert(5);

	}
	
	public static Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut)); //wait for alert and switch to alert
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}
	
	public static void acceptAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();;
	}
	public static void dismissAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}
	public static void alertSendKeys(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}

}
