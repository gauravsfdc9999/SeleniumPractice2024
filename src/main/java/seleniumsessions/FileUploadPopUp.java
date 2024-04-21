package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		
		//check the input type -- file is mandatory
		////input[@name='upfile']
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.xpath("//input[@name='upfile']")).sendKeys("C:\\Users\\UiPath\\Downloads\\seleniumFileUpload.docx");
		
	}

}
