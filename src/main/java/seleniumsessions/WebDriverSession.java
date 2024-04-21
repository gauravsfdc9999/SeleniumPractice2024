package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSession {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		System.out.println("page title: "+title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		//driver.close();
		driver.quit(); 
		//session is invalid with same Id
		try {
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("class error");
		}
		
		
		//with driver.close() session id is maintained but gets invalid
		//driver.quit() session id is becomes null
		
		
	}

}
