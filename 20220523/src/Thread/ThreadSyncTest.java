package Thread;

public class ThreadSyncTest {

	public static void main(String[] args) {
		Increment inc = new Increment();
		
		IncThread t1 =new IncThread(inc);
		IncThread t2 =new IncThread(inc);
		IncThread t3 =new IncThread(inc);
		
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		}catch(InterruptedException e) {}
		System.out.println("숫자의 합 : " +inc.getNum());
	}
			

}
