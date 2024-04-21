package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectWithSelectClass {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		WebElement dropDownEle = driver.findElement(By.xpath("//select[@multiple]"));
		Select select = new Select(dropDownEle);
		System.out.println(select.isMultiple());
		
		if(select.isMultiple()) {
			select.selectByValue("American");
			select.selectByValue("Andean");
			select.selectByVisibleText("Greater flamingo");
			select.selectByVisibleText("Lesser flamingo");
		}
		
		select.deselectByValue("Andean");
//		select.deselectAll();
		
		List<WebElement> selectOptionList = select.getAllSelectedOptions();
		for(WebElement e: selectOptionList) {
			System.out.println("selected elements: "+e.getAttribute("value"));
		}
		
		System.out.println(select.getFirstSelectedOption().getText());
	}

}
