package testngsessions;

import org.testng.annotations.Test;

public class PriorityTest {
	
	@Test(priority=1)
	public void eTest() {
		System.out.println("@Test -- eTest");
	}
	
	//5. test cases will run based on alphabetical order
	@Test(priority=5)
	public void dTest() {
		System.out.println("@Test --- dTest");
	}
	//11.
	@Test(priority=-1)
	public void cTest() {
		System.out.println("@Test --- cTest");
	}
	@Test
	public void bTest() {
		System.out.println("@Test --- bTest");
	}
	@Test(priority=1)
	public void aTest() {
		System.out.println("@Test --- aTest");
	}
}
