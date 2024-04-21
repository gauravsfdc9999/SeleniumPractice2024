package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIFrameConcepts {

	static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("testing");
		
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("selenium");
		
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("cool");
		
		//sele 4.x
		driver.switchTo().parentFrame(); //level up in frame f2
		driver.findElement(By.id("jex")).clear();
		driver.switchTo().defaultContent(); //main page
		System.out.println("main page: "+driver.findElement(By.tagName("h3")).getText());
		
	}

}
