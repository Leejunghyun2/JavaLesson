package Exam01;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		    String result ="";
			System.out.print("나이를 입력하세요 : ");
				int age = Integer.parseInt(sc.nextLine());
			System.out.print("성적을 입력하세요 : ");
				double var = Double.parseDouble(sc.nextLine());
				
				if(age < 30 && var >= 3.5)
				{
					result = ("추천 대상입니다.");
				} else 
				{
					result =("추천 대상이 아닙니다.");
				}
				System.out.println(result);
	}
}
