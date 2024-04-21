package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSuggestions {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
//		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(3000);
		
//		List<WebElement> suggestionList = driver.findElements(By.xpath("//ul[@class='G43f7e' and @role='listbox']//div[@class='wM6W7d']/span"));
//		System.out.println(suggestionList.size());
//		for(WebElement e:suggestionList ) {
//			System.out.println(e.getText());
//			String text = e.getText();
//			if(text.contains("webdriver")) {
//				e.click();
//				break;
//			}
//		}
		
		By searchGoogle = By.name("q");
		By searchOptions = By.xpath("//ul[@class='G43f7e' and @role='listbox']//div[@class='wM6W7d']/span");
		doSearch(searchGoogle, searchOptions, "Gaurav","gupta");
		
		//driver.close();
		
		driver.get("https://groww.in/");
		By searchField = By.id("globalSearch23");
		By seachOptions = By.xpath("//div[@class='se28Suggestions']//div[@class='gsc23SuggestionText']//div/span");
		doSearch(searchField, seachOptions, "HDFC", "Advantage");
		
	}
	
	public static void doSearch(By searchLocator,By searchSuggestion, String searchKey, String value) throws InterruptedException {
		driver.findElement(searchLocator).sendKeys(searchKey);
		Thread.sleep(3000);
		List<WebElement> suggestionList = driver.findElements(searchSuggestion);
		for(WebElement e: suggestionList) {
			System.out.println(e.getText());
			String text = e.getText();
			if(text.contains(value)) {
				e.click();
				break;
			}
		}
	}

}
