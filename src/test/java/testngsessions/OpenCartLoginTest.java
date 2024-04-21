package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartLoginTest extends BaseTest{

	
	@Test(priority=1)
	public void titleTest() {
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println("title test");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login","title is not matched");
	}
	@Test(priority=3)
	public void imageTest() {
		System.out.println("image test");
		boolean flag = driver.findElement(By.cssSelector(".img-responsive")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void urlTest() {
		System.out.println(driver.getCurrentUrl());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("account/login"));
	}


}
