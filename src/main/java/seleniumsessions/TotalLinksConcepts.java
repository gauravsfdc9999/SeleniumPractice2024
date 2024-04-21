package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TotalLinksConcepts {

	public static void main(String[] args) {
		//1. total links
		//2. print the text of each link use getText()
		//3. avoid blank text
		//4. broken link --later
		//5. link will be under tag <a>
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//find out all the elements ---> FEs
		//list is order based collection
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("total links on page: "+allLinks.size());
		
		//printing all the links
		for(int i=0;i<allLinks.size();i++) {
			if(allLinks.get(i).getText().length()!=0) {
				System.out.println(allLinks.get(i).getText());
			}
			
		}
		
		System.out.println("--------------");
		for(WebElement e : allLinks) {
			if(e.getText().length()!=0){
				System.out.println(e.getText());
			}
		}
		System.out.println("--------------");
		//to find specific text fields
		List<WebElement> allTextFields = driver.findElements(By.className("form-control"));
		System.out.println(allTextFields.size());
		
		for(WebElement e : allTextFields) {
			e.sendKeys("testing");
		}
		 
		driver.close();
	}

}
