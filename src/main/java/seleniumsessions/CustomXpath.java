package seleniumsessions;

import org.openqa.selenium.By;

public class CustomXpath {

	public static void main(String[] args) {
		//Xpath : address of the element in the DOM
		//XMLpath
		//1. Absolute xpath
		//Absolute xpath is risky - it will change with change in DOM structure
		///html/body/div[2]/div/div/div[2]/div[1]/div/div[1]/a/img
		
		//2. relative xpath (custom xpath)
		//1. using any attribute
		//tagname[@attrname = 'value']
		
		//Below is the examples single atrribute
		//input[@id = 'input-email']
		//input[@name = 'email']
		
		//input[@name] --5 - use with findelements
		//input[@value = 'Login'] --1
		
		//Below is the examples multiple atrribute
		//tagname[@attrname = 'value' and @attr2 = 'value' and @attr3 = 'value']
		//tagname[@attrname = 'value' and @attr2 = 'value' OR @attr3 = 'value']
		
		//input[@value= 'Login' and @type ='submit']--1
		//input[@type='text' or @type='email'] -- 4
		//input[@type and @type='email']
		//input[@type and @type]
		//a[@href] - finding those element which have href property
		
		//3. text()
		//tagname[text()= 'value']
		//h2[text()='New Customer']
		//a[text() = 'Wish List']
		
		//4. Text() and attributes together :
		//tagname[@attr = 'value' and text() = 'value']
		
		//a[@class = 'dropdown-toggle' and text() = 'Desktops']
		//a[@class = 'dropdown-toggle' and text() = 'Desktops' and @data-toggle = 'dropdown']
		
		//5. contains() with attr:
		//tagname[contains(@attrName, 'value')]
		//input[contains(@placeholder, 'E-Mail')]
		//input[contains(@placeholder, 'Address')]
		
		//6. tagname[contains(@attr1, 'value') and @attr2='value']
		//input[contains(@placeholder, 'Address') and @name='email']
		//input[contains(@placeholder, 'Address') and @name='email' and contains(@id, 'email')]
		//a[contains(@href,'wishlist')] --3
		
		//dynamic IDs:
		//<input id=firstname_123>
		//<input id=firstname_145>
		//<input id=firstname_256>
		//to handle dynamic 
		//input[contains(@id, 'firstname_')]
		
		
		//7. contains() with text()
		//tagname[contains(text(), 'value')]
		//p[contains(text(), 'Customer service, IT, and CRM')]
		//a[contains(text(), 'Customer')]
		
		//8.contains() with text() and attribute
		//tagname[contains(text(), 'value')and contains(@attr, 'value')]
		//a[contains(text(), 'Notebooks') and contains(@href, 'category')]
		
		//9.contains() with text() and attribute
		//tagname[contains(text(), 'value')and contains(@attr, 'value') and @attr3 = 'value']
		
		//10. starts-with()
		//tagname[starts-with(@atrr, 'value')]
		//input[starts-with(@placeholder, 'E-Mail')]
		
		//11.starts-with() with text()
		//tagname[starts-with(text(), 'value')]
		//a[starts-with(text() , 'Forgotten')]
		
		//12. ends-with () is not supported in xpath with latest browser
		
		//13. index based xpath: should be avoided
		// (//a[text()='Forgotten Password'])[2]
		//By.xpath("(//a[text()='Forgotten Password'])[2]");
		//(//a[@class='list-group-item'])[13]
		//(//input[@class='form-control'])[1] --firstname on register page
		
//		By fgt_pwd = By.xpath("(//a[text() = 'Forgotten Password'])[1]"); correct syntax
		//(//a[text() = 'Forgotten Password'])[position()=1] -- index based xpath can also be wrritten with postion() function
		
		//last() functions to get the last element
		//(//input[@class='form-control'])[last()] -- to select last element with class as form-control
		
		// to select 2nd last element
		//(//input[@class='form-control'])[last()-1]
		
		//interview question verify that the last element is 'Help' and above that it should have Amazon Assistant
		//((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a[@class='nav_a'])[last()] -- help 
		//((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a[@class='nav_a'])[last()-1]
		
		//https://www.decathlon.in/running/running-shoes-15086?id=15086&type=c
		//(//div[@class='productCarouselTitleSwiperWrapperBestSeller']//div[@class='relative']/div)[position()=2]//img[@alt='Rating']/parent::div/span
		
		//Normalize space in xpath - 
		//label[normalize-space()='Yes']
		
		
		

	}

}
