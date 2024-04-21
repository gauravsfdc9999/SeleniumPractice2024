package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTest {
	//before annotations: non static methods
	//1.
	@BeforeSuite
	public void dbConnection() {
		System.out.println("@BeforeSuite -- DB Connections");
	}
	//2.
	@BeforeTest
	public void createUser() {
		System.out.println("@BeforeTest -- Create user");
	}
	//3.
	@BeforeClass
	public void launchBrowser() {
		System.out.println("@BeforeClass -- launchBrowser");
	}
	//4. runs after each test method //7. //10.
	@BeforeMethod 
	public void login() {
		System.out.println("@BeforeMethod -- login");
	}
	
	//8.
	@Test
	public void titleTest() {
		System.out.println("@Test -- titleTest");
	}
	
	//5. test cases will run based on alphabetical order
	@Test
	public void headerTest() {
		System.out.println("@Test --- headerTest");
	}
	//11.
	@Test
	public void urlTest() {
		System.out.println("@Test --- urlTest");
	}
	//6. it will be executed after each test method //9. //12.
	@AfterMethod
	public void  logout() {
		System.out.println("@AfterMethod -- logout");
	}
	//13.
	@AfterClass
	public void  closeBrowser() {
		System.out.println("@AfterClass -- closeBrowser");
	}
	//14.
	@AfterTest
	public void  deleteUser() {
		System.out.println("@AfterTest -- deleteUser");
	}
	//15.
	@AfterSuite
	public void  disconnectWithDB() {
		System.out.println("@AfterSuite -- disconnectWithDB");
	}
	
}
