package chap03;

import java.util.Scanner;

public class Report {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int age=0;
		double h=0;
		
		System.out.print("�̸� : ");
		name = sc.nextLine();
		
		System.out.print("Ű : ");
		h = Double.parseDouble(sc.nextLine());
		
		
		System.out.print("���� : ");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println(name + "���� 10�� �� "+ (age+10)+"�� �Դϴ�.");
		System.out.printf("%s���� 10�� �� %d�� �Դϴ�.", name,age+10);
		
	}

}
