package Exam01;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		    String result ="";
			System.out.print("���̸� �Է��ϼ��� : ");
				int age = Integer.parseInt(sc.nextLine());
			System.out.print("������ �Է��ϼ��� : ");
				double var = Double.parseDouble(sc.nextLine());
				
				if(age < 30 && var >= 3.5)
				{
					result = ("��õ ����Դϴ�.");
				} else 
				{
					result =("��õ ����� �ƴմϴ�.");
				}
				System.out.println(result);
	}
}
