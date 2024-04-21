package seleniumsessions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

public class RelativeLocatorsConcept2 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//selenium 4.X:        left of ele<--ele --> right of ele and above of ele and below of ele and near of element (50px)
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login"); //parent
		driver.manage().window().maximize();
		
		WebElement baseElement = driver.findElement(By.id("input-email"));
		
		//driver.findElement(with(By.className("control-label")).above(baseElement)).getText();
		String aboveText = 
		driver.findElement(with(By.cssSelector("label[for=\"input-email\"]")).above(baseElement)).getText();
		System.out.println(aboveText);
		
		WebElement headerEle = driver.findElement(By.xpath("//h2[text() = 'New Customer']"));
		List<WebElement> paraTextList = driver.findElements(with(By.tagName("p")).below(headerEle).above(By.linkText("Continue"))
				.toLeftOf(driver.findElement(with(By.cssSelector("label[for=\"input-email\"]")).above(baseElement))));
		for(WebElement e : paraTextList) {
			System.out.println(e.getText());
		}
		
		//Assignment check right of privacy policy check box is available
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By privacyLocator  = By.xpath("//a[@class='agree']/b[contains(text(),'Privacy')]");
		By continueButton = By.xpath("//input[@type='submit']");
		WebElement baseElementRight = driver.findElement(privacyLocator);
		WebElement baseElementLeft = driver.findElement(continueButton);
		
		WebElement checkBox= driver.findElement(with(By.xpath("//input[@type='checkbox']")).toLeftOf(baseElementLeft).toRightOf(baseElementRight));
		System.out.println(checkBox.getAttribute("name"));
		if(checkBox.getAttribute("name").equals("agree")) {
			System.out.println("yayya yay test case passed");
		}
		driver.close();
		

	}

}
