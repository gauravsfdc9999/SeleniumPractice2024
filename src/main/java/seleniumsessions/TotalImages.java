package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
//		driver.get("https://unsplash.com/");
		driver.get("https://www.pexels.com/");
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		System.out.println("Total images on page is: "+imagesList.size());
		
		//web scrapping
		for(WebElement e : imagesList) {
			String altValue = e.getAttribute("src");
			if(altValue !=null) {
				System.out.println("attributes of src images are : "+altValue);
			}
			
		}
		
		driver.close();
		
	}

}
