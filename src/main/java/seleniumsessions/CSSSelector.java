package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelector {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		//in case incorrect values are given then - InvalidSelectorException: invalid selector : An invalid or illegal selector was specified
		//driver.findElement(By.cssSelector("input[id!!@='username']")).sendKeys("test");
		
//		driver.findElement(By.cssSelector("CSSSelector"));
		//id
		//#id
		//tagname#id
		//#username
		// input#username
		
		//class:
		// .classname
		//tagname.classname
//		.login-email
		//input.login-email
		//class + id
		// .class#id
		// #id.classname
		//tagname.classname#id -- input.login-email#username
		//multiple class - .c1.c2.c3.... .cn
		// input.form-control.private-form__control.login-email
		// input.form-control#username.private-form__control.login-email
		
		//other attributes 
		//tagname[attr='value'] --css
		////tagname[@attr='value'] -- xpath
		//input[type='email'][id='username'] -- in css id can be used as attr and # also
		
		//input[placeholder*='Address'] -- contains with * and Starts with ^
		//input[placeholder^='E-Mail']
		//ends with -- $ -- input[placeholder$='Address']
		
		//text is available in xpath but not supported in CSS
		
		//parent to child concept in CSS
		//form#hs-login > div -- direct child
		//form#hs-login  div -- direct+indirect child
		//select[name='Country']#Form_getForm_Country>option or select[name='Country']#Form_getForm_Country option
		
		//child to parent is not allowed - backward traversing is not allowed in css
		//child to grandparent (ancestor) -- not allowed - backward traversing is not allowed
		//preceding sibling is not allowed
		
		//sibling concept in CSS
		//1. Following sibling = '+' (immediate following sibling) 2. capture all sibling '~'
		//option[value='Algeria']+option and                        option[value='Algeria']~option
		
		
		//comma in CSS - can be used sanity check
		int mand_fields_count=
		driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,input#remember")).size();
		if(mand_fields_count==4) {
			System.out.println("PASS - all imp mandatory fields are available on page : "+mand_fields_count);
		}
		
		//not in css -- :not(input#password)
		//div.form-group > input.form-control:not(input#input-password)  -- exclude password
		//div.form-group > input.form-control:not(input#input-email) --- exclude email
		
		//index in css - :
		//select#Form_getForm_Country > option:nth-of-type(5) -- 5th option
		//select#Form_getForm_Country > option:nth-of-type(n) -- all the elements
		//select#Form_getForm_Country > option:nth-of-type(5)
		//select#Form_getForm_Country > option:first-child -- first child
		//select#Form_getForm_Country > option:last-child -- last child
		//select#Form_getForm_Country > option:nth-child(4) - 4th child
		//select#Form_getForm_Country > option:nth-last-child(2) - 2nd last child element
		//select#Form_getForm_Country > option:nth-child(odd) -- odd option elements
		//select#Form_getForm_Country > option:nth-child(even) -- even elements
		//select#Form_getForm_Country > option:nth-child(n+4) -- start from 4th child element
		//select#Form_getForm_Country > option:nth-child(4n) -- every 4th element or jump to 4th element (or increment by 4)
		
		//odd and even in xpath
		//(//select[@id='Form_getForm_Country']/option)[position() mod 2=0] -- even
		// (//select[@id='Form_getForm_Country']/option)[position() mod 2=1] -- odd element
		//(//select[@id='Form_getForm_Country']/option)[position() mod 2=1]
		
		//cascaded classes in css:
		//tagname.c1.c2.c3....cn
		driver.findElement(By.cssSelector("input.form-control.private-form__control.login-password.m-bottom-3"));
		
		
		//Normalize space
		////label[normalize-space()='Yes']
		driver.get("https://www.espncricinfo.com/series/australia-in-new-zealand-2023-24-1388188/new-zealand-vs-australia-1st-test-1388226/full-scorecard");
		List<WebElement> ele = driver.findElements(By.cssSelector("table.ds-w-full.ds-table.ds-table-md.ds-table-auto.ci-scorecard-table tr:not(tr.ds-hidden)"));
		for(WebElement e : ele) {
			System.out.println(e.getText());
		}
				
		
		
		
		
		
	}

}
