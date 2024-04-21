package seleniumsessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		//implicitly wait is global wait and may cause performance issue
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); //sele 3.x
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //sele 4.x
		// implicitly wait is global wait : applied to all the element by default
		
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		
		//login page:
		//total timeout = 10sec
		long start = System.currentTimeMillis();
		driver.findElement(By.id("Form_getForm_Name")).sendKeys("test");
		long end = System.currentTimeMillis();
		System.out.println("elasped time : "+(end-start));
		//e2: 10 sec
		//e3: 10:8=2
		//e4... en :10
		
		//home page : timeout 15 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//he1:15
		//he2:15
		//logout:15
		
		//login page:10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//e1 e2 e3:10 sec
		
		//cart page:0 : nullify of imp wait:0
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		//case2:
		//login page: 10sec
		//e1: 10sec
		//e2: 10
		//e3: 10
		//e4: 10
		
		//case 3: 
		//its only applicable for WebElements
		//not applicable for non-webelement : like alert, title, url, brower window etc
	}

}
