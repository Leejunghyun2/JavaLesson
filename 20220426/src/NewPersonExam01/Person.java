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
		System.out.println("이름 : " + name );
		System.out.println("전화번호 : "+ phoneNumber.substring(0,3)+ "-" + phoneNumber.substring(3,7)+"-"+phoneNumber.substring(7,11));
		if(birth.equals("")== false) {
			System.out.println("생일 : " + birth.substring(0,4)+"년 "+birth.substring(4,6)+"월 "+birth.substring(6,8)+"일");
		}
		
	}
}
	
	
	
	
	
	
