package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTimeOutConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120)); //page load time out
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		long time = driver.manage().timeouts().getPageLoadTimeout().getSeconds();
		System.out.println(time);
		
	}

}
