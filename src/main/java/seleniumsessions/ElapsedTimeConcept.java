package seleniumsessions;

public class ElapsedTimeConcept {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("start time :"+(start));
		start = start+10000;
		Thread.sleep(3000);
		long end = System.currentTimeMillis()+10000;
		System.out.println("end time :"+(end));
		System.out.println("elapsed time :"+(end-start));
		System.out.println("elapsed time in seconds :"+(end-start)/1000);
	}

}
