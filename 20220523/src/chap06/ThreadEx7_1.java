package chap06;

public class ThreadEx7_1 extends Thread {
	public void run() {
		for(int i=100; i>0; i--) {
			System.out.print(i);
			try {
				sleep((int)(Math.random()*100)*10);
			}catch(Exception e) {}
		}
		
	}
}
