package chap03;

import java.util.Scanner; // ctrl + shift + o

public class Ver02 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int kor=0, eng=0, math=0, total=0;
		double avg = 0.0;
		System.out.print("�̸� : ");
		name = sc.nextLine();
		System.out.print("�������� == > ");
		kor = Integer.parseInt(sc.nextLine());
		System.out.print("�������� == > ");
		eng = Integer.parseInt(sc.nextLine());
		System.out.print("�������� == > ");
		math = Integer.parseInt(sc.nextLine());
		
		total = kor + eng + math;
		avg = total/3.0;
		
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+total);
		System.out.println("��� : "+avg);
		
		
	}
}
