package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		//FirefoxDriver driver = new FirefoxDriver(); //not recommended
		WebDriver driver = new FirefoxDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String currentTitle=driver.getTitle();
		System.out.println("page title: "+currentTitle);
		
		//checkpoint or validation or testing or verifcation/act Vs exp
		if(currentTitle.equals("Your Store")) {
			System.out.println("correct title---PASS");
			
		}
		else
		{
			System.out.println("incorrect title---FAIL");
		}
		//automation steps + verification point ---> automation testing
		//test steps + verification point --- test case
		
		//get current url
		String currentUrl= driver.getCurrentUrl();
		System.out.println(currentUrl);
		if(currentUrl.contains("naveenautomationlabs.com")) {
			System.out.println("correct title---PASS");
		}
		else {
			System.out.println("correct title---FAIL");
		}
		//to close the browser: quit() and close()
		driver.close();
	
	}

}
