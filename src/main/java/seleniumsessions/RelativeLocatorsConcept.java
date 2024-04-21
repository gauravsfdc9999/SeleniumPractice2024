package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//selenium 4.X:        left of ele<--ele --> right of ele and above of ele and below of ele and near of element (50px)
		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada"); //parent
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement baseElement = driver.findElement((By.linkText("Toronto, Canada")));
		
		//driver.findElement(RelativeLocator.with(null)) --> to avoid writting relativelocator import static
		String leftText = driver.findElement(with(By.tagName("p")).toLeftOf(baseElement)).getText();
		System.out.println(leftText);
		String rightText = driver.findElement(with(By.tagName("p")).toRightOf(baseElement)).getText();
		System.out.println(rightText);
		String aboveCity = driver.findElement(with(By.tagName("p")).above(baseElement)).getText();
		System.out.println(aboveCity);
		String belowCity = driver.findElement(with(By.tagName("p")).below(baseElement)).getText();
		System.out.println(belowCity);
		
		String nearElement = driver.findElement(with(By.tagName("p")).near(baseElement)).getText();
		System.out.println(nearElement);
		
		
	}

}
