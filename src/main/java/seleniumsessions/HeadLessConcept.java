package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HeadLessConcept {

	public static void main(String[] args) {
		//headless vs headed
		//headless : no browser visibility
		//run tc's on CI/CD/Jenkins/Linux : headless
		//faster
		//recommended: not recommended/not preferred mode
		//local execution
		//problems: its not an actual user simulation
		//complex apps/HTML DOM: it might not work
		//alerts and pop ups could be a problem
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
//		co.addArguments("--incognito");
        // Create an object of Edge Options class
        EdgeOptions edgeOptions = new EdgeOptions();
 
        // pass the argument –headless to Edge Options class.
        edgeOptions.addArguments("--headless");
//		WebDriver driver = new ChromeDriver(co);
        WebDriver driver = new EdgeDriver(edgeOptions);
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://naveenautomationlabs.com/opencart/");
		driver.get("https://www.google.com");
		System.out.println("Title of page: "+ driver.getTitle());
		driver.close();
	}

}
