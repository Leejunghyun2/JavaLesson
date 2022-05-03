package chap06;

import java.util.Scanner;

public class IfExam03 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하시오 :");
		int var = Integer.parseInt(sc.nextLine());
		char grade = ' ',opt = '0';
		if(var >= 90)
		{
			grade = 'A';
			if(var % 10 >= 8)
			{
				opt = '+';
			}
			else if(var % 10 <= 3)
			{
				opt = '-';
			}
		
		}
		else if(var >= 80)
		{
			grade = 'B';
			if(var % 10 >= 8)
			{
				opt = '+';
			}
			else if(var % 10 <= 3)
			{
				opt = '-';
			}
		
		}
		else if(var >= 70)
		{
			grade = 'C';
			if(var % 10 >= 8)
			{
				opt = '+';
			}
			else if(var % 10 <= 3)
			{
				opt = '-';
			}
		
		}
		else if(var >= 60)
		{
			grade = 'D';
			if(var % 10 >= 8)
			{
				opt = '+';
			}
			else if(var % 10 <= 3)
			{
				opt = '-';
			}
		
		}
		else
		{
			grade = 'F';
		}
		System.out.printf("당신의 학점은 %c%c 입니다.",grade,opt);
		
	}
}
