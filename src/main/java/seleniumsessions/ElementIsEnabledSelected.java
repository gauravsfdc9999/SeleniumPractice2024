package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsEnabledSelected {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.linkText("Sign Up")).click();
		String currentPageUrl = driver.getCurrentUrl();
		String currentPageHandle = driver.getWindowHandle();
		System.out.println("Current page url: "+currentPageUrl);
		System.out.println("Current page handle: "+currentPageHandle);
		
		//isDisplayed
		boolean buttonDisplayed = driver.findElement(By.id("submitButton")).isDisplayed();
		boolean checkBoxDisplayed = driver.findElement(By.name("agreeTerms")).isDisplayed();
		System.out.println("Button is displayed "+buttonDisplayed +" and "+"checkBox is diplayed "+checkBoxDisplayed);
		
		//isDisplayed - present on the page
		//isEnabled - Element is obv present but its enabled or not
		boolean flag = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag);//false
		
		boolean checkBoxFlag = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(checkBoxFlag);//false
		
		driver.findElement(By.name("agreeTerms")).click(); //select the checkbox
		
		checkBoxFlag = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(checkBoxFlag);//true
		
		flag = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag);//true
		
		
		driver.close();

	}

}
