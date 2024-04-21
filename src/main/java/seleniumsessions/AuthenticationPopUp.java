package seleniumsessions;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUp {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		//passing the username and password in the url but it is 
		//driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
		//OR
		//basic auth:
		String username = "admin";
		String password = "admin";
//		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/digest_auth");
		
		//Selenium 4.x onwards - Interface has been created named as HasAuthentication interface
		((HasAuthentication)driver).register(() -> new UsernameAndPassword(username, password));
		driver.get("https://the-internet.herokuapp.com/digest_auth");
		
	}

}
