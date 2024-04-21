package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SHubWebTable {
	
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		selectUser("Joe.Root");
		selectUser("John.Smith");
		
		System.out.println(getUserDetails("John.Smith"));
		System.out.println(getUserDetails("Joe.Root"));
		
		driver.close();
		
		
	}
	/**
	 * Method to select check box for user
	 * @param String userName
	 */
	public static void selectUser(String userName) {
		String xpath = "//a[text()='"+userName+"']/ancestor::tr//input[@type='checkbox']";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static List<String> getUserDetails(String userName) {
		////a[text()='Joe.Root']/parent::td/following-sibling::td
		String xpath = "//a[text()='"+userName+"']/parent::td/following-sibling::td";
		List<String> userInfoList = new ArrayList<>();
		List<WebElement> userInfoEles = driver.findElements(By.xpath(xpath));
		for(WebElement e:userInfoEles) {
			String text = e.getText();
			userInfoList.add(text);
		}
		
		return userInfoList;
	}

}
