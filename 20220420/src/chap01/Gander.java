package chap01;

import java.util.Scanner;

public class Gander {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = "";
		char ch = ' ';
		
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ��� : �� :123456-1234567 : ");
		num = sc.nextLine();
		ch = num.charAt(7);
		
		switch(ch)
		{
			case '1':
			System.out.println("����");
			break;
			case '3':
		    System.out.println("����");
		    break;
			case '2': case '4':
		    System.out.println("����");
		    break;
			default:
			System.out.println("�߸� �Է��ϼ˽��ϴ�.");
		}
	}
}
