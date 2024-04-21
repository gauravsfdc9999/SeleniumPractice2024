package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementConcepts {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//Pseudo element are special element like * sign for mandatory field ::before or ::after
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(1000);
		
		String scriptPseudo = "return window.getComputedStyle(document.querySelector('label[for=input-firstname]'),'::before').getPropertyValue('content');";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String mand_text= js.executeScript(scriptPseudo).toString();
		System.out.println(mand_text);
		if(mand_text.contains("*")) {
			System.out.println("FN is mandatory field---");
		}
		
		//div.alert.alert-danger.alert-dismissible
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String warningText = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		System.out.println(warningText);

	}

}
