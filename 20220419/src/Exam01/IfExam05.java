package Exam01;

import java.util.Scanner;

public class IfExam05 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ð��� �Է��ϼ��� : ");
			int time = Integer.parseInt(sc.nextLine());
		
		System.out.print("�� ���Աݾ��� �Է��ϼ��� : ");
			int buy = Integer.parseInt(sc.nextLine());
			double per = 0;
		
			if(time < 12)
			{
				per = buy * 0.95;
				System.out.printf("���Խð� : %d �� \n�� ���Աݾ� : %d \n�������ұݾ� : %d \n",time,buy,(int)per);
			}
			else if(time >= 12)
			{
				per = buy * 0.975;
				System.out.printf("���Խð� : %d �� \n�� ���Աݾ� : %d \n�������ұݾ� : %d \n",time,buy,(int)per);
			}
	}
}
