package chap06;

public class Thread7_2 extends Thread{
	public void run() {
		System.out.println();
		for(int i=100; i>0; i--) {
			System.out.print(i);
			try {
				sleep((int)(Math.random()*100)*10);
			}catch(Exception e) {}
		}
		
	}
}
