package chap06;

import javax.swing.JOptionPane;

public class ThreadEx7 {
	public static void main(String[] args) {
		ThreadEx7_1 t1 = new ThreadEx7_1();
		Thread7_2 t2 = new Thread7_2();
		//t1.setDaemon(true);
		t1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է��ϼ���");
		System.out.println("�Է��ϽŰ��� " + input + "�Դϴ�.");
	}
}
