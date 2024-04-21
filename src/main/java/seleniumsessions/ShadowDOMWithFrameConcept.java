package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMWithFrameConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		String pizzaNameJS="return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement pizzaEle=(WebElement)js.executeScript(pizzaNameJS);
		pizzaEle.sendKeys("cheese pizza");
		
		//with iframe
		//browser --shadow DOM (open) -- iframe -- element
		//create JS path for frame -- create frame webelement -- switch to frame -- then check the element
		String frameToSwitch = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		//JavascriptExecutor js1 =(JavascriptExecutor)driver;
		WebElement frameToSwitchElement = (WebElement)js.executeScript(frameToSwitch);
		driver.switchTo().frame(frameToSwitchElement);
		driver.findElement(By.id("glaf")).sendKeys("PASS");
		

	}

}
