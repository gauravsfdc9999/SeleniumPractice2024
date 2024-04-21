package seleniumsessions;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGMapHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//SVG -- scalar vector graphs
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		//by css - iframe[id *='map-instance']
		List<WebElement> stateList= driver.findElements(By.xpath("//*[name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']/*[name()='g']"));
		//by css svg#map-svg g#regions g.region
		System.out.println(stateList.size());
		
		
		Actions act = new Actions(driver);
		for(WebElement e: stateList) {
			act.moveToElement(e).build().perform();
			System.out.println(e.getAttribute("id"));
			Thread.sleep(500);
		}
		
		
	}

}
