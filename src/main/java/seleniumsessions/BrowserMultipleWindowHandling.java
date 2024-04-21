package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMultipleWindowHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //parent
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String parentWindowId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click(); //child
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click(); //child
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click(); //child
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click(); //child
		
		//fetch window id:
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it= windowHandles.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			if(!windowId.equals(parentWindowId)) {
				driver.switchTo().window(windowId);
				System.out.println("Current url: "+ driver.getCurrentUrl());
				System.out.println("Page title: "+ driver.getTitle());
				driver.close();
			}

		}
		driver.switchTo().window(parentWindowId);
		System.out.println("Current url: "+ driver.getCurrentUrl());
		System.out.println("Page title: "+ driver.getTitle());



	}

}
