package Exam01;

import java.util.Scanner;

public class IfExam03 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String gender = "";
		System.out.print("������ �Է��ϼ��� : 1. ���� 2. ���� ");
			gender = sc.nextLine();
		
		System.out.print("���� ������ �Է��ϼ��� : ");
			int toeic = Integer.parseInt(sc.nextLine());
		
			if((gender.equals("����") && toeic >= 700 ) ||(gender.equals("����") && toeic >= 800 ))
			{
				System.out.println("�װ� �¹��� ���� �ڰ� �������Դϴ�.");
			}
			else
			{
				System.out.println("�����Ұ�");
			}
			/*
			if((gender == 2 && toeic >= 700 ) ||(gender == 1 && toeic >= 800 ))
			{
				System.out.println("�װ� �¹��� ���� �ڰ� �������Դϴ�.");
			}
			else
			{
				System.out.println("�װ� �¹��� ���� �ڰ� �̴����Դϴ�.");
			}
		    */
	}
}
