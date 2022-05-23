package chap06_2;

public class ThreadTest {
	public static void main(String[] args) {
		
		Sum s = new Sum();
		
		AdderThread t1 = new AdderThread(s, 1, 50);
		AdderThread t2 = new AdderThread(s, 51, 100);
		
		t2.start();
		t1.start();
		try {
		t1.join();
		t2.join();
		}catch(InterruptedException e) {}
		System.out.println("1부터 100까지의 합 :" + s.getNum());
	}

}
