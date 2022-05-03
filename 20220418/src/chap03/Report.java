package chap03;

import java.util.Scanner;

public class Report {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int age=0;
		double h=0;
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		System.out.print("키 : ");
		h = Double.parseDouble(sc.nextLine());
		
		
		System.out.print("나이 : ");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println(name + "씨는 10년 후 "+ (age+10)+"살 입니다.");
		System.out.printf("%s씨는 10년 후 %d살 입니다.", name,age+10);
		
	}

}
