package chap1;

import java.util.Scanner;

public class MenuChoice {
	int kind,color,gb,price;
	
	MenuChoice(int kind,int color,int gb,int price){
		this.kind = kind;
		this.color = kind;
		this.gb = gb;
		this.price = price;
	}
	MenuChoice(){
		this(1,1,1,1);
	}
		
	
	
	
	
	String MenuChoiceKind() {
	Scanner sc = new Scanner(System.in);
	System.out.print("종류를 선택하세요 : 1.갤럭시 2.아이폰");
	int i = Integer.parseInt(sc.nextLine());
	return "("+i+")";
	}
}


