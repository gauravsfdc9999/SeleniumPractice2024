package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
/**
 * 
 * @author gaurav gupta
 *
 */

public class Browserutil {
	WebDriver driver;
	
	//launch browser or initialize driver
	/**
	 * this method is used to initialize the browser based on given browser name
	 * @param browserName
	 * @return driver instance
	 */
	public WebDriver launchBrowser(String browserName) {
		System.out.println("Browser name: "+browserName);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("plz pass the right browser..."+browserName);
			throw new BrowserException("browser not found");
			//break;
		}
		
		return driver;
	}
	
	public void launchURL(String url) {
		if(url == null) {
			throw new BrowserException("Url is null");
		}
		if(url.indexOf("https")==0 || url.indexOf("https")==0) {
			driver.get(url);
		}
		else {
			throw new BrowserException("HTTP is missing in url");
		}
		
	}
	
	public void launchURL(URL url) {
		if(url == null) {
			throw new BrowserException("Url is null");
		}
		String appURL = String.valueOf(url); //converting the URL to string
		if(appURL.indexOf("https")==0 || appURL.indexOf("https")==0) {
			driver.get(appURL);
		}
		else {
			throw new BrowserException("HTTP is missing in url");
		}
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	

}
