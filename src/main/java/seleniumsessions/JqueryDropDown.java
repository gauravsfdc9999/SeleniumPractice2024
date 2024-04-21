package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDown {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		Thread.sleep(2000);
//		driver.findElement(By.id("justAnInputBox")).click();
//		
//		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
//		System.out.println("total count of choices "+choiceList.size());
//		
//		for(WebElement e : choiceList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("choice 1")) {
//				e.click();
//				break;
//			}
//		}
		
		By dropDown = By.id("justAnInputBox");
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		
		//1. tc_01 :: single selection
//		doSelectChoice(dropDown, choices, "choice 1");
		
		//2. multiselection using ... parameter string is array or varargs
		//doSelectChoice(dropDown, choices, "choice 1","choice 2 1","choice 7");
		
		//3. select All choices considering all as unique selection
		doSelectChoice(dropDown, choices, "all");
	}
	
	/**
	 * This method is used to handle single, multiple selection. Please pass "all" in case of all selections.
	 * @param ... varargs -- spread parameter(js)
	 * @param choices
	 * @param values
	 * @throws InterruptedException
	 */
	public static void doSelectChoice(By dropDownLocator, By choices, String... values) throws InterruptedException {
		driver.findElement(dropDownLocator).click();
		Thread.sleep(2000);

		List<WebElement> choiceList = driver.findElements(choices);
		System.out.println("total count of choices " + choiceList.size());

		if (!values[0].equalsIgnoreCase("all")) {
			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);
				for (String val : values) {
					if (text.equals(val)) {
						e.click();
						// break;
					}
				}
			}
		} else {
			System.out.println("all selection");
			for (WebElement e : choiceList) {
//				String text = e.getText();
				try {
					e.click();
				} catch (ElementNotInteractableException e2) {
					System.out.println("All selection done");
					break; // optional
				}
			}
		}

	}

}
