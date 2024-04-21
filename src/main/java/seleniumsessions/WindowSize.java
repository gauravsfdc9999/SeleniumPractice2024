package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSize {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		//tab keys with pause to fill form
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize(); //maximise the window
//		driver.manage().window().fullscreen(); //for big monitor to fit on screen
		
		//specific size of window for responsive view port
//		Dimension dim = new Dimension(432, 932);
//		driver.manage().window().setSize(dim);
		
		//height and width of element
		WebElement fn=driver.findElement(By.id("input-firstname"));
		int ht = fn.getSize().getHeight();
		int wdt = fn.getSize().getWidth();
		System.out.println("height: "+ht+" and width :"+wdt);
		
		//getting location of webelement
		Point fnPoint = fn.getLocation();
		int fn_X = fnPoint.getX();
		int fn_Y  = fnPoint.getY();
		System.out.println("X coordinate: "+fn_X+" and Y coordinate :"+fn_Y);
		
		//to capture background color
		WebElement continue_Button=driver.findElement(By.xpath("//input[@value='Continue']"));
		System.out.println("Colour of continue button:-> "+continue_Button.getCssValue("background-color"));
		System.out.println("Colour of continue button:-> "+continue_Button.getCssValue("font-size"));
		
	}

}
