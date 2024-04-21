package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfoTable {
	static WebDriver driver;
	
	public static void main(String[] args) {
			driver = new ChromeDriver();
			driver.get("https://www.espncricinfo.com/series/australia-in-new-zealand-2023-24-1388188/new-zealand-vs-australia-1st-test-1388226/full-scorecard");
//			String wkt_takerName = driver.findElement(By.xpath("//span[text()='Travis Head']/ancestor::td/following-sibling::td//span/span"))
//					.getText();
			driver.manage().window().maximize();
			System.out.println(getWicketTakerName("Travis Head"));
			System.out.println(getWicketTakerName("Pat Cummins"));
			System.out.println(ausFirstInningRuns("Pat Cummins"));
			System.out.println("Pat Cummins first inning score : "+ausFirstInningRuns("Pat Cummins")+" stats "+ausFirstInningScore("Pat Cummins"));
			System.out.println("Travis Head first inning score : "+ausFirstInningRuns("Travis Head")+" stats "+ausFirstInningScore("Travis Head"));
			
			//span[text()='Steven Smith']/ancestor::tr/td/following-sibling::td -- 14
			//(//span[text()='Steven Smith']/ancestor::tbody)[1]/tr/td[contains(@class,'ds-min-w-max !ds')] - batsman out by
			//(//span[text()='Steven Smith']/ancestor::tbody)[1]/tr/td[contains(@class,'ds-min-w-max !ds')]/following-sibling::td[contains(@class,'ds-text-right')]/strong - score of every batsman in 1st inning
			
			
			
	}
	
	public static String getWicketTakerName(String bastmanName) {
		//return driver.findElement(By.xpath("(//span[text()='"+bastmanName+"']/ancestor::table)[1]//td/following-sibling::td//span/span")).getText();
		return driver.findElement(By.xpath("//span[text()='"+bastmanName+"']/ancestor::td/following-sibling::td//span/span"))
				.getText();
	}
	
	public static String ausFirstInningRuns(String batsmanName) {
		String xpath = "(//span[text()='"+batsmanName+"']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right ds-text-typo')])[1]";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static List<String> ausFirstInningScore(String batsmanName) {
		String xpath = "(//span[text()='"+batsmanName+"']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right ds-text-typo')])[1]/following-sibling::td[contains(@class,'ds-text-right')]";
		List<String> scoreCardList = new ArrayList<>();
		List<WebElement> scoreEles = driver.findElements(By.xpath(xpath));
		for(WebElement e :scoreEles) {
			String text = e.getText();
			if(!text.equals(null)) {
			scoreCardList.add(text);
			}
		}
		return scoreCardList;
	}

}
