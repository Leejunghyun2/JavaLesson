package NewPersonExam01;

import java.util.Scanner;

public class Person {
	Scanner sc = new Scanner(System.in);
	String name;
	String phoneNumber;
	String birth;

	   
	
	Person(String name, String phoneNumber, String birth) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
		showPerson2();
	}

	
	Person(){
		
	}
	
	
	void showPerson2() {
		System.out.println("�̸� : " + name );
		System.out.println("��ȭ��ȣ : "+ phoneNumber.substring(0,3)+ "-" + phoneNumber.substring(3,7)+"-"+phoneNumber.substring(7,11));
		if(birth.equals("")== false) {
			System.out.println("���� : " + birth.substring(0,4)+"�� "+birth.substring(4,6)+"�� "+birth.substring(6,8)+"��");
		}
		
	}
}
	
	
	
	
	
	
