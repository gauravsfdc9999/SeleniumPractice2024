package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FEUtils {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.pexels.com/");
		
		By images = By.tagName("img");
		By links = By.tagName("a");
		System.out.println("total images count : "+getElementsCount(images));
		System.out.println("total links count : "+getElementsCount(links));
		
		List<String> eleTexts= getElementsTextList(links);
		System.out.println(eleTexts);
		if(eleTexts.contains("Explore")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("FAILED");
		}
		
		ArrayList<String> eleAttValues = getElementAttributeList(images, "src");
		System.out.println(eleAttValues);
		
		
		driver.close();
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
		
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> textList = new ArrayList<String>();//pc=0
		for(WebElement e: eleList) {
			String text = e.getText();
			if(text.length()!=0) {
				textList.add(text);
			}
			
		}
		return textList;
	}
	
	public static ArrayList<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleAttList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String attrValue = e.getAttribute(attrName);
			if(attrValue.length()!=0) {
				eleAttList.add(attrValue);
			}
			
		}
		return eleAttList;
	}

}
