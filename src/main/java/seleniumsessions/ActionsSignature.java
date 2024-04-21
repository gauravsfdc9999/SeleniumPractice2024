package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsSignature {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		//signaure creation with actions class
		driver = new ChromeDriver();
		driver.get("https://signaturegenerator.com/draw");
		Thread.sleep(2000);
		
		WebElement canvas = driver.findElement(By.xpath("//canvas[@class='canvas__inner']"));
		
		Actions act = new Actions(driver);
		Action signature = act.click(canvas)
								.moveToElement(canvas, 20, 32)
								.clickAndHold(canvas)
								.moveByOffset(50, -60)
								.clickAndHold(canvas)
								.moveByOffset(20, -80)
								.moveByOffset(50, -150)
								.moveByOffset(-140, 150)
								.moveByOffset(50, -150).build();
		
		signature.perform();
								

	}

}
