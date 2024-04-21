package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowConceptSel4 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //parent
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String parentWindowId = driver.getWindowHandle();
		//New open window concept //Selenium 4.x
		
		driver.switchTo().newWindow(WindowType.TAB); //blank tab will open and it will switch to that
		
		driver.get("https://www.google.com/");
		System.out.println("Page title: "+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println("page title: "+driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com/");
		System.out.println("Page title: "+driver.getTitle());
		driver.close();
		

	}

}
