package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		String browserName = "chrome";
		
		Browserutil brUtil = new Browserutil();
		brUtil.launchBrowser(browserName);
		brUtil.launchURL("https://www.google.com/");
		String actTitle = brUtil.getPageTitle();
		if(actTitle.contains("Google")) {
			System.out.println("title --- PASS");
		}
		else {
			System.out.println("title --- FAIL");
		}
		
		String url = brUtil.getPageUrl();
		if(url.contains("google.com")) {
			System.out.println("url --- PASS");
		}
		else {
			System.out.println("url --- FAIL");

		}
		brUtil.closeBrowser();
		
	}

}
