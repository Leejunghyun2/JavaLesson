package chap06;

import java.util.Scanner;

public class IfExam02 {

	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int age = 0;
		System.out.print("���̸� �Է��ϼ��� : ");
		age = Integer.parseInt(sc.nextLine());
		
		
		
	   if(age > 19)
	   {
		   System.out.println("�����Դϴ�.");
	   }
	   else
	   {
		   System.out.println("������ �ƴմϴ�.");
	   }
	   
	   age = age % 2;
	   if(age==1)
	   {
		   System.out.println("Ȧ���Դϴ�.");
	   }
	   else
	   {
		   System.out.println("¦���Դϴ�.");   
	   }
	
		
		
	}
}
