package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		System.out.println("total rows : "+(rowCount-1));
		
		//fetching the column data
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[5]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[1]";
		for(int row=2;row<=rowCount;row++) {
			String compXpath = beforeXpath +row+ afterXpath;
//			System.out.println(compXpath);
			String text = driver.findElement(By.xpath(compXpath)).getText();
			System.out.println(text);
		}
		
		////*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[5]/td[2]
		
		beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		afterXpath = "]/td[2]";
		for(int row=2;row<=rowCount;row++) {
			String contactXpath = beforeXpath +row+ afterXpath;
//			System.out.println(contactXpath);
			String text = driver.findElement(By.xpath(contactXpath)).getText();
			System.out.println(text);
		}
		
		System.out.println("----------------");
		List<WebElement> tableDataList = driver.findElements(By.xpath("//th[text()='Company']/parent::tr/following-sibling::tr/td"));
		for(WebElement e : tableDataList) {
			System.out.println(e.getText());
		}
		
		//specific column data
		//th[text()='Company']/parent::tr/following-sibling::tr/td[1]
		//column count - //table[@id='customers']//th
		//table[@id='customers']//tr/td[2] - 2nd column data
		
		//trversing on the basis on column
		int colCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		for(int col=1;col<=colCount;col++) {
			System.out.println("-----------");
			System.out.println(driver.findElement(By.xpath("//table[@id='customers']//th["+col+"]")).getText());
			System.out.println("-------");
			////table[@id='customers']//tr/td[1]
			List<WebElement> colData = driver.findElements(By.xpath("//table[@id='customers']//tr/td["+col+"]"));
			for(WebElement e: colData) {
				System.out.println(e.getText());
			}
			System.out.println("-----------");
		}
		
	}

}
