package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutorConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//browser understand -- JS
		//JS --> JavaScriptExecutor --> executeScript()
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver; //Interface to interface casting
//		String title =js.executeScript("return document.title;").toString();
//		System.out.println(title);
//		
//		String url =js.executeScript("return document.URL;").toString();
//		System.out.println(url);
		Actions act = new Actions(driver);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		System.out.println(jsUtil.getTitleByJS());
		jsUtil.refreshBrowserByJS();
		jsUtil.getAlertMessageByJS("Hi My New Alert");
		Alert alt = driver.switchTo().alert();
		alt.accept();
		jsUtil.generateConfirmPopUp("Are you sure about it");
		alt=driver.switchTo().alert();
		alt.dismiss();
		driver.get("https://classic.crmpro.com/");
		System.out.println(jsUtil.getPageInnertext());
		WebElement forgotPass = driver.findElement(By.linkText("Forgot Password?"));
		jsUtil.scrollIntoViewElement(forgotPass);
		WebElement backUpSecurity = driver.findElement(By.xpath("//h3[contains(text(),'Backup & Security')]"));
		Thread.sleep(1000);
		jsUtil.scrollIntoViewElement(backUpSecurity);
		jsUtil.drawBorder(backUpSecurity);
		jsUtil.flashElement(backUpSecurity);
		jsUtil.clickElementByJS(driver.findElement(By.xpath("//input[@type='submit']")));

		
	}

}
