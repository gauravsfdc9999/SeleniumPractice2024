package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		//6 topcasting
		WebDriver driver = new ChromeDriver(); //valid and recommended, use to run on local machine
		SearchContext driver1 = new ChromeDriver();//valid not recommended
		RemoteWebDriver driver3 = new ChromeDriver(); //valid and recommended
		ChromiumDriver driver4=new ChromeDriver(); //valid not recommended, as it supports only edge and chrome browser
		
		//run tests on the remote/server/cloudmachine / grid/ sauce labs/browserstack/lamdatest
		//WebDriver driver5 = new RemoteWebDriver(serverUrl, capabilities);
		ChromeDriver driver6 = new ChromeDriver(); // valid but works only for chrome browser

		//SearchContext driver7= new RemoteWebDriver(null,null);args //valid but not recommended
		
		
	}

}
