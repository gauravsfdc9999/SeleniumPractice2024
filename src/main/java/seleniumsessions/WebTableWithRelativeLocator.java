package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class WebTableWithRelativeLocator {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		//selenium 4.X:        left of ele<--ele --> right of ele and above of ele and below of ele and near of element (50px)
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/"); //parent
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		By playerLocator = By.linkText("Joe.Root");
		WebElement playerEle = driver.findElement(playerLocator);
		
		driver.findElement(with(By.id("ohrmList_chkSelectRecord_21")).toLeftOf(playerEle)).click();
		//getting all the information of player
		////table[@id='resultTable']//a[text()='Joe.Root']/../following-sibling::td
//		List<WebElement> playerInfoEle = driver.findElements(with(By.xpath("//table[@id='resultTable']//a[text()='Joe.Root']/../following-sibling::td")).toRightOf(playerEle));
//		for(WebElement e: playerInfoEle) {
//			System.out.println(e.getText());
//		}
		
		By infoLocator = By.xpath("//table[@id='resultTable']//a[text()='Joe.Root']/../following-sibling::td");
		List<String> playerInfo = getPlayerInfo(playerLocator, infoLocator);
		for(String playerIn : playerInfo) {
			System.out.println(playerIn);
		}

	}
	
	public static List<String> getPlayerInfo(By refLocator, By infoLocator) {
		WebElement playerEle = driver.findElement(refLocator);
		List<String> playerInfo = new ArrayList<String>();
		List<WebElement> playerInfoEle = driver.findElements(with(infoLocator).toRightOf(playerEle));
		for(WebElement e: playerInfoEle) {
			//System.out.println(e.getText());
			playerInfo.add(e.getText());
		}
		return playerInfo;
	}

}
