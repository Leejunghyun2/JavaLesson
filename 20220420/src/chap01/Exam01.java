package chap01;

import java.util.Scanner;

public class Exam01 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = ' ';
		
		System.out.print("�����ϳ��� �Է��ϼ��� ==> ");
		String temp =  sc.nextLine();
		c = temp.charAt(0);
		if('0' <= c && c <= '9'){
			System.out.println("���� �Դϴ�.");
		} else if('A' <= c && c <= 'Z') {
			System.out.println("������ �빮�� �Դϴ�.");
		} else if('a' <= c && c <= 'z') {
			System.out.println("������ �ҹ��� �Դϴ�.");
		} else {
			System.out.println("�߸� �Է� �ϼ˽��ϴ�.");
		}
		
		
	}
}