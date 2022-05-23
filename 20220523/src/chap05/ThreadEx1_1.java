package chap05;

public class ThreadEx1_1 extends Thread {

	@Override
	public void run() {
		for(int i=0; i<1000 ; i++) {
			System.out.println(getName());
		}
	}
	
}
