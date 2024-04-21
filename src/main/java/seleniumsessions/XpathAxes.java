package seleniumsessions;

public class XpathAxes {

	public static void main(String[] args) {
		//parent to direct child : /
		//form/div/input -- only direct
		
		//parent to direct + indirect child: //
		//select[@id='Form_getForm_Country']//option
		//div[@id='content']//img -- direct+indirect
		
		//child to parent -- backward traversing
		////input[@id='input-email']/../../../../../../../../../..  --- reached HTML
		//input[@id='input-email']/parent::div/parent::form -- same as above backward traversing
		
		//input[@id='input-email']/parent::div -- direct parent
		
		//child to got to grandparent
		//input[@id='input-email']/ancestor::form
		//input[@id='input-email']/ancestor::form/ancestor::body/parent::html
		
		//a[text()='Recurring payments']/ancestor::aside
		
		//a[text()='Recurring payments']/preceding-sibling::a[text()='Downloads'] -- preceding-sibling
		
		//a[text()='Recurring payments']/following-sibling::a[text()='Returns'] -- following sibling
		
		//input[@id='input-email']/preceding-sibling::label
		
		//web table - https://selectorshub.com/xpath-practice-page/ - checking select box against given user
		//option1. //a[text()='Joe.Root']/ancestor::tr/td/input[@type='checkbox']
		//option2. //a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		//option3. //a[text()='Joe.Root']/ancestor::tr//input[@type='checkbox']
		
		
		
	}

}
