package testngsessions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@BeforeTest
	public void createUser() {
		System.out.println("@BeforeTest -- Create user");
	}
	
	@Test(invocationCount = 10,priority=2)
	public void createUserTest() {
		System.out.println("@Test -- createUserTest");
	}
	
	@Test(priority=1)
	public void paymentTest() {
		System.out.println("@Test -- paymentTest");
	}
	
	@AfterTest
	public void  deleteUser() {
		System.out.println("@AfterTest -- deleteUser");
	}
	
	
}
