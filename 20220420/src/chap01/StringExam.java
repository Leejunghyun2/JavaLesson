package chap01;

import java.util.Scanner;

public class StringExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = "abc"; // new로 새로 안 만들면 있는 값을 가르킴
		String str4 = new String("abc"); // new로 새로 안 만들면 있는 값을 가르킴
		String str5 = sc.nextLine(); // new로 새로 안 만들면 있는 값을 가르킴
		String str6 = sc.nextLine(); // new로 새로 안 만들면 있는 값을 가르킴
		
		
		System.out.println(str1.equalsIgnoreCase("Abc"));
		System.out.println("abc"=="abc");
		System.out.println(str1=="abc");
		System.out.println(str1==str2);
		System.out.println(str4==str2);
		System.out.println(str5==str6);
	}
}
