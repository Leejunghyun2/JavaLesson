package chap06;

import java.util.Scanner;

public class IfExam02 {

	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int age = 0;
		System.out.print("나이를 입력하세요 : ");
		age = Integer.parseInt(sc.nextLine());
		
		
		
	   if(age > 19)
	   {
		   System.out.println("성인입니다.");
	   }
	   else
	   {
		   System.out.println("성인이 아닙니다.");
	   }
	   
	   age = age % 2;
	   if(age==1)
	   {
		   System.out.println("홀수입니다.");
	   }
	   else
	   {
		   System.out.println("짝수입니다.");   
	   }
	
		
		
	}
}
