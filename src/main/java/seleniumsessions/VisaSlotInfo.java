package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisaSlotInfo {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		int i=0;
		driver.get("https://visaslots.info/#google_vignette");
		do{
		String text = driver.findElement(By.xpath("(//a[text()='NEW DELHI VAC']/ancestor::tr)[position()=1]/td[@class='earliest']")).getText();
		System.out.println("after 60 sec : "+text);
		if(text.contains("2024")) {
			System.out.println("Yayay---- slot available book: "+text);
			break;
		}
		Thread.sleep(60000);
		driver.navigate().refresh();
		i++;
		}while(i<1000);
	}

}
