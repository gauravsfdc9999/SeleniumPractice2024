package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrameHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("div#imageTemplateContainer img")).click();
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("gaurav");
		
		driver.switchTo().defaultContent();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		driver.switchTo().frame(2);
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		driver.navigate().back();
		String veRegister = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(veRegister);

	}

}
