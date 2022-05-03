package Exam01;

import java.util.Scanner;

public class IfExam03 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String gender = "";
		System.out.print("성별을 입력하세요 : 1. 남자 2. 여자 ");
			gender = sc.nextLine();
		
		System.out.print("토익 성적을 입력하세요 : ");
			int toeic = Integer.parseInt(sc.nextLine());
		
			if((gender.equals("여자") && toeic >= 700 ) ||(gender.equals("남자") && toeic >= 800 ))
			{
				System.out.println("항공 승무원 지원 자격 가능자입니다.");
			}
			else
			{
				System.out.println("지원불가");
			}
			/*
			if((gender == 2 && toeic >= 700 ) ||(gender == 1 && toeic >= 800 ))
			{
				System.out.println("항공 승무원 지원 자격 가능자입니다.");
			}
			else
			{
				System.out.println("항공 승무원 지원 자격 미달자입니다.");
			}
		    */
	}
}
