package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//SVG -- scalar vector graphs
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("macbook");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button//*[local-name()='svg' and @fill='none']")).click();
		
	}

}
