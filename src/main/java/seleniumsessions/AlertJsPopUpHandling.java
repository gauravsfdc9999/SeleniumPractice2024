package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJsPopUpHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//popup
		//alert
		//confirmation
		//prompt
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1.
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		//to click on alert 'ok'
		alert.accept();
		
//		alert.dismiss();//Cancel the alert
		
		//2. Confirmation alert
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert2 = driver.switchTo().alert();
		String text2 = alert.getText();
		System.out.println(text2);
		alert.accept(); //click ok
		Thread.sleep(2000);
		//3. prompt pop up
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert3 = driver.switchTo().alert();
		String text3 = alert.getText();
		System.out.println(text3);
		alert.sendKeys("gaurav");
		Thread.sleep(2000);
		alert.accept();
		
		
	}

}
