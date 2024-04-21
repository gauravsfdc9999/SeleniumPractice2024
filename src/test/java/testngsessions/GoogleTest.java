package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
//	WebDriver driver;
//	@BeforeTest
//	public void setUp() {
//		driver=new ChromeDriver();
//		driver.get("https://www.google.com/");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
	
	@Test(priority=1)
	public void titleTest() {
		//driver.get("https://www.google.com/");
		System.out.println("title test");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google","title is not matched");
	}
	@Test(priority=3)
	public void imageTest() {
		System.out.println("image test");
		boolean flag = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Ignore
	@Test(priority=2, enabled=false)
	public void urlTest() {
		System.out.println("title test");
		System.out.println(driver.getCurrentUrl());
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("google"));
	}
//	@AfterTest
//	public void tearDown() {
//		System.out.println("AfterMethod -- tearDown");
//		driver.quit();
//	}
}
