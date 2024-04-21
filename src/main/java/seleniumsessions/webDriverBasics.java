package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriverBasics {

	public static void main(String[] args) {
		//steps - open browser
		//enter url
		//get the title
		//verify the title - actual vs expected
		//WebDriver is interface, topcasting. Automation steps
		WebDriver driver = new ChromeDriver();
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
