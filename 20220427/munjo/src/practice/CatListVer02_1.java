package practice;

import java.util.Scanner;

public class CatListVer02_1 {
	
	static Scanner sc = new Scanner(System.in); // 값 입력은 메소드2개에서 다 받아야하는데 
	//각 메소드 안에다가 스캐너하면 다 따로 적어야하니까 걍 클래스 밑에 적고 모든 메소드에서 사용가능하게함
	  //여러 메소드에서 사용하려면 클래스 밑에 선언해야함.	
	
	public static void main(String[] args) {
		int choice=0; //순서 잘보기!! 초이스 선언->메뉴보여주고->입력값 저장해야지
			
		while(true) {   //메인 메소드가 static인데 메인에서 사용하는 메소드인 show랑 input에
			showMenu(); //static안붙으면 오류남. 메소드 실행을 위한 scanner도 static 붙이기
			choice = Integer.parseInt(sc.nextLine()); //입력받은 값 저장
			
			if(choice==1) {
				inputData();
			}
			else if(choice==2) {
				System.out.println("종료합니다");
				return;
			}
		}
	
	}
	static void showMenu() {
		System.out.println("선택하세요");
		System.out.println("1. 데이터 입력하기");
		System.out.println("2. 프로그램 종료");
		System.out.print("=>");
		//입력값은 여기서 저장할 필요가 없대 근데 값을 입력받긴 해야하니까 scanner는 필요함ㅎ
	}
	
	static void inputData() { //값 입력받는 걸 인풋데이터라는 메소드 하나로 싹 묶기
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
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
