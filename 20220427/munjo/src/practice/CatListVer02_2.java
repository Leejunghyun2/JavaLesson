package practice;

import java.util.Scanner;

public class CatListVer02_2 {

	static Scanner sc = new Scanner(System.in); 
	
	public static void main(String[] args) {
		int choice=0; 
		
		while(true) {   
			showMenu(); 
			choice = Integer.parseInt(sc.nextLine()); 
			
			switch(choice) {
			case 1:
				inputData();
				break; //break는 다음 케이스로 가지 않게 하는 것 =조건문을 빠져나오는 것
			case 2:
				System.out.println("종료합니다");
				return; //return은 반복문에서 빠져나오게 하는 것. 반복을 끝냄.!!!
			}
		}
	
	}
	static void showMenu() {
		System.out.println("선택하세요");
		System.out.println("1. 데이터 입력하기");
		System.out.println("2. 프로그램 종료");
		System.out.print("=>");
	}
	
	static void inputData() { 
		System.out.print("이름을 입력하세요 : "); //변수선언 간소화..!
		String name = sc.nextLine(); //그냥 변수선언하고 사용하는게 귀찮아서? 한번에 한건가?
		System.out.print("나이를 입력하세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("성별을 입력하세요 : ");
		String gender = sc.nextLine();
		System.out.print("색(무늬)를 입력하세요 : ");
		String color = sc.nextLine();
		
		Cat c = new Cat(name, age, gender, color);
		
		c.showInfo();
	}

	

}
