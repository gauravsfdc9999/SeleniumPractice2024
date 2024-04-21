package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRightContextClick {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(3000);
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		
		List<WebElement> rightEle= driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root > li:not(li.context-menu-separator)"));
		for(WebElement e: rightEle) {
			System.out.println(e.getText());
			if(e.getText().equals("Copy")) {
				System.out.println("Text copy is found breaking loop");
				e.click();
				break;
			}
		}
	}

}
