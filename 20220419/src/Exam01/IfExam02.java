package Exam01;

import java.util.Scanner;

public class IfExam02 {

	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���ڸ� �Է��Ͻÿ� : ");
			int first = Integer.parseInt(sc.nextLine());
		System.out.print("�ι�° ���ڸ� �Է��Ͻÿ� : ");
			int second = Integer.parseInt(sc.nextLine());
		
		/*
		 �Ѵ� Ȧ�� �Ǵ� ¦���� ������ �� ������ ���� �������� �ȳ����� �Ѵ� ¦ �� �̰ų� Ȧ���� ��Ÿ���� ����� �ֽ��ϴ�.
		 int third = first + second;
		 if( third % 2 == 0 )
		 {
		  System.out.println("�� �� ��� ¦�� �̰ų� Ȧ�� �Դϴ�.);
		 }
		 */
			if(first % 2 == 0 && second % 2 == 0)
			{
				System.out.println("�� ���ڴ� ���� ¦���Դϴ�.");
			}
			else if(first % 2 == 1 && second % 2 == 1)
			{
				System.out.println("�� ���ڴ� ���� Ȧ���Դϴ�.");
			}
			else
			{
				System.out.println("�� ���ڰ� �ٸ��ϴ�.");
			}
		
	}
}
