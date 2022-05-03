package chap01;

import java.util.Scanner;

public class Exam01 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = ' ';
		
		System.out.print("문자하나를 입력하세요 ==> ");
		String temp =  sc.nextLine();
		c = temp.charAt(0);
		if('0' <= c && c <= '9'){
			System.out.println("숫자 입니다.");
		} else if('A' <= c && c <= 'Z') {
			System.out.println("영문자 대문자 입니다.");
		} else if('a' <= c && c <= 'z') {
			System.out.println("영문자 소문자 입니다.");
		} else {
			System.out.println("잘못 입력 하셧습니다.");
		}
		
		
	}
}