package practice;

public class Cat {
	String name;
	int age;
	String gender;
	String color;
	
	Cat(){
		this("나비", 0, "여","삼색"); //기본형 메소드에 초기값 넣어준 거
	}
	
	Cat(String name, int age, String gender, String color){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.color = color;
	}
	
	Cat(String name, int age, String gender){
		this(name, age, gender, null);
	}
					//color.length=0 도 가능
	void showInfo() {//근데 스캐너로 입력받을 때는 "abc"랑 입력받은 abc는 다르다고 인식함. 
		if(color==null || color=="") //color==""은 왜 안되는거지? 엔터로 치니까 됨. 단 ""사이에 띄우면 안됨.
			System.out.printf("고양이 이름 : %s %n고양이 나이 : %d %n고양이 성별 : %s%n" ,name, age, gender);
		else	
		System.out.printf("고양이 이름 : %s %n고양이 나이 : %d %n고양이 성별 : %s %n고양이 색(무늬) : %s %n",name, age, gender, color);
	}
	
		
		
	}
	


