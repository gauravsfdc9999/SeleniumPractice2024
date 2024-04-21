package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartLogintest {

	public static void main(String[] args) {
		
		Browserutil brutil =new Browserutil();
		WebDriver driver =brutil.launchBrowser("chrome");
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(brutil.getPageTitle());
		
		//locators
		By userName = By.id("input-email");
		By pswd = By.id("input-password");
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(userName, "test@gmail.com");
		eleUtil.doSendKeys(pswd, "test@1234");
		//brutil.closeBrowser();
		
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println(brutil.getPageTitle());
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By emailId = By.id("input-email");
		By telephoneNo = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		//sending values to the fields locator
		eleUtil.doSendKeys(firstName, "something");
		eleUtil.doSendKeys(lastName, "something");
		eleUtil.doSendKeys(emailId, "test@gmail.com");
		eleUtil.doSendKeys(telephoneNo, "9898976789");
		eleUtil.doSendKeys(password, "test@123");
		eleUtil.doSendKeys(confirmPassword, "test@123");
		
		brutil.closeBrowser();
		
		
		
	}

}
