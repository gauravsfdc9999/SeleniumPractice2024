package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		
		//1st : fetch window handle Ids
		Set<String> windowHandles =driver.getWindowHandles();
		//iterate the set since its unordered collection
		Iterator<String> it =windowHandles.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window ID: "+parentWindowId);
		String childWindowId = it.next();
		System.out.println("child window ID: "+childWindowId);
		
		//2nd: switching work:
		driver.switchTo().window(childWindowId);
		System.out.println("child window url: "+driver.getCurrentUrl());
		System.out.println("child window title: "+driver.getTitle());
		
		driver.close(); //closes the child window donot use quit() method as it will close all the windows including parent
		
		//3rd: swtich back to parent window
		driver.switchTo().window(parentWindowId);
		System.out.println("current parent url is: "+driver.getCurrentUrl());

	}

}
