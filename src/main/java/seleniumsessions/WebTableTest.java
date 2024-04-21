package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("apiautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
		Thread.sleep(4000);
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click(); //contacts not from DOM but what is visible on page
		
		selectContact("Joe Root");
		selectContact("Josh Buttler");
		System.out.println("Joe Root company: "+getCompanyName("Joe Root"));
		System.out.println("Josh Buttler company: "+getCompanyName("Josh Buttler"));
		
	}
	
	public static void selectContact(String contactName) {
		//(//a[text()='Josh Buttler']/parent::td/preceding-sibling::td/input[@type='checkbox'])
		String xpath = "(//a[text()='"+contactName+"']/parent::td/preceding-sibling::td/input[@type='checkbox'])";
		driver.findElement(By.xpath(xpath)).click();
		
	}
	public static String getCompanyName(String contactName) {
		////a[text()='Josh Buttler']/parent::td/following-sibling::td/child::a[@context='company']
		String xpath = "//a[text()='"+contactName+"']/parent::td/following-sibling::td/child::a[@context='company']";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	public static String getPhoneNumber(String contactName) {
		// (//a[text()='Josh Buttler']/parent::td/following-sibling::td/child::span[@context='phone'])[1]
			String xpath = "(//a[text()='Josh Buttler']/parent::td/following-sibling::td/child::span[@context='phone'])[1]";
			return driver.findElement(By.xpath(xpath)).getText();
		
	}
	public static void getContactsInfoList(String contactName) {
		String xpath = "(//a[text()='Josh Buttler']/parent::td/following-sibling::td/child::span[@context='phone'])";
	}
	
	public static void getContactsEmail(String contactName) {
		
	}

}
