package chap05;

public class ThreadEx1_2 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName());
		}

	}

}