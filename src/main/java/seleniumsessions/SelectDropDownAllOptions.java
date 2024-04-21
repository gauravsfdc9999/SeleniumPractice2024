package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.CountryOnly;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownAllOptions {

		static WebDriver driver;
		public static void main(String[] args) {
			driver = new ChromeDriver();
			driver.get("https://orangehrm.com/en/30-day-free-trial");
			//WebElement country = driver.findElement(By.id("Form_getForm_Country"));
			//Select select = new Select(country);
			
			//getting all the values in drop down
//			List<WebElement> countryOptions = select.getOptions();
//			System.out.println(countryOptions.size());
//			
//			for(WebElement e: countryOptions) {
//				String text = e.getText();
//				System.out.println(text);
//				if(text.equals("India")) {
//					e.click();
//					break;
//				}
//			}
			//utility method
			By country = By.id("Form_getForm_Country");
			doSelectDropDownValue(country, "India");

	}
		
		
		public static List<String> getDropDownOptionsTextList(By locator) {
			List<WebElement> optionsList = getDropDownOptionsList(locator);
			List<String> optionTextList = new ArrayList<String>();//pc=0
			for(WebElement e:optionsList ) {
				String optionText = e.getText();
				optionTextList.add(optionText);
			}
			
			return optionTextList;
			
		}
		public static List<WebElement> getDropDownOptionsList(By locator) {
			WebElement element = driver.findElement(locator);
			Select select = new Select(element);
			return select.getOptions();
		}
		public static int getDropDownValuesCount(By locator) {
//			WebElement element = driver.findElement(locator);
//			Select select = new Select(element);
			
			return getDropDownOptionsList(locator).size();
		}
		
		public static void doSelectDropDownValue(By locator, String textValue) {
//			WebElement element = driver.findElement(locator);
//			Select select = new Select(element);
//			List<WebElement> optionList = select.getOptions();
			
			List<WebElement> optionList = getDropDownOptionsList(locator);
			
			for(WebElement e: optionList) {
				String text = e.getText();
				System.out.println(text);
				if(text.equals(textValue)) {
					e.click();
					break;
				}
			}
		}
		
		public static void printSelectDropDownValue(By locator) {
			List<WebElement> optionList = getDropDownOptionsList(locator);
			for(WebElement e: optionList) {
				String text = e.getText();
				System.out.println(text);
			}
		}

}
