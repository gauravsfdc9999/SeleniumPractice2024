package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownWithoutUsingSelectClass {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		//not allowed to use select class and select the value from drop down
		
		//By country = By.id("Form_getForm_Country"); //will give only 1 value of drop down
		
		By options = By.xpath("//select[@id='Form_getForm_Country']/option");
		doSelectValueFromDropDown(options, "India");
		doSelectValueFromDropDownIndex(options, 9,null);
		
	}
	
	public static void doSelectValueFromDropDown(By locator, String textValue) {
		List<WebElement> optionsList = driver.findElements(locator);
		
		for(WebElement e: optionsList) {
			String text = e.getText();
			if(text.equals(textValue)) {
				e.click();
				break;
			}
			
		}
	}
	
	public static void doSelectValueFromDropDownIndex(By locator, int index, String defaultSelected) {
		List<WebElement> optionsList = driver.findElements(locator);
		int counter=0;
		for(WebElement e: optionsList) {
			String text = e.getText();
			if(text!=null && !(text.equals(defaultSelected))) {
				counter++;
			}
			if(counter==index) {
				e.click();
				break;
			}
			
		}
	}

}
