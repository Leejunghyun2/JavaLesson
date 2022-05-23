package chap06;

import javax.swing.JOptionPane;

public class ThreadEx7 {
	public static void main(String[] args) {
		ThreadEx7_1 t1 = new ThreadEx7_1();
		Thread7_2 t2 = new Thread7_2();
		//t1.setDaemon(true);
		t1.start();
		
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력하신값은 " + input + "입니다.");
	}
}
