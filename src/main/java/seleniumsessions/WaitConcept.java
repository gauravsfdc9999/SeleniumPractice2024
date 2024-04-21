package seleniumsessions;

public class WaitConcept {

	public static void main(String[] args) {
		//script --sync--> app(slow, server, slowness, network)
		//sync: wait
		//1. static wait: Thread.sleep(10000): 10 sec : but element is available in 2 sec still it will wait for 10 sec
		//2. dynamic wait: 10 sec: 2 sec: 8sec: will be cancelled
			//2.a. Implicity wait
			//2.b. Explicity wait 
					//i. WebDriverWait (class)
					//ii. FluentWait (class)
		//wait(Interface): Untill(abstract method);--> fluentWait(class): untill(){}+ other methods --> WebDriverWait(class)
		
	}

}
