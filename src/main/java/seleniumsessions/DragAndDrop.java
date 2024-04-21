package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(3000);
		//it happend on element to element basis
		//file on the page is not possible -- NA selenium
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		//option 1.
//		act.clickAndHold(sourceEle)
//			.moveToElement(targetEle)
//				.release()
//					.build().perform();
		
		//sele 4 new method is available for same -- direct method
		//act.dragAndDrop(sourceEle, targetEle).perform();
		
		//Action is interface and Actions is class
		Action act2 = act.clickAndHold(sourceEle).moveToElement(targetEle).release().build();
		act2.perform();
		
		
	}

}
