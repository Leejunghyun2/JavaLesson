package step2;

import java.util.Scanner;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸� : ");
		String name = sc.nextLine();
		System.out.println("���� : ");
		String phoneNumber = sc.nextLine();
		System.out.println("���� : ");
		String birth = sc.nextLine();
		
		
		Person p = new Person(name,phoneNumber,birth);
		
		p.showPhoneInfo();
		
	}
	
}