package chap01;

import java.util.Scanner;

public class Gander {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = "";
		char ch = ' ';
		
		System.out.println("주민등록번호를 입력하세요 : 예 :123456-1234567 : ");
		num = sc.nextLine();
		ch = num.charAt(7);
		
		switch(ch)
		{
			case '1':
			System.out.println("남자");
			break;
			case '3':
		    System.out.println("남자");
		    break;
			case '2': case '4':
		    System.out.println("여자");
		    break;
			default:
			System.out.println("잘못 입력하셧습니다.");
		}
	}
}
