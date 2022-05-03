package chap03;

import java.util.Scanner; // ctrl + shift + o

public class Ver02 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int kor=0, eng=0, math=0, total=0;
		double avg = 0.0;
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("국어점수 == > ");
		kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어점수 == > ");
		eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학점수 == > ");
		math = Integer.parseInt(sc.nextLine());
		
		total = kor + eng + math;
		avg = total/3.0;
		
		System.out.println("이름 : "+name);
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
		
		
	}
}
