package testngsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest{
	
	@Test(priority=1)
	public void titleTest() {
		//driver.get("https://orangehrm.com/en/30-day-free-trial");
		System.out.println("title test");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "30-Day Advanced Free Trial | OrangeHRM","title is not matched");
	}
//	@Test(priority=3)
//	public void imageTest() {
//		System.out.println("image test");
//		boolean flag = driver.findElement(By.cssSelector(".img-responsive")).isDisplayed();
//		Assert.assertTrue(flag);
//	}
	@Test(priority=2)
	public void urlTest() {
		System.out.println(driver.getCurrentUrl());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("30-day-free-trial"));
	}

}
