package Exam01;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int wage = 0;
			int per = 0;
		System.out.print("������ �Է��ϼ��� :");
			int abil = Integer.parseInt(sc.nextLine());
		System.out.print("�ٹ��ð��� �Է��ϼ��� :");
			int time = Integer.parseInt(sc.nextLine());
		
			if(abil == 7 || abil == 8)
			{
				if(time >= 40)
				{
					per = time - 40;
					wage = (15000*40) + (per*1500*15); // double�� �Ⱦ��� ���� 15000* 1.5 ��� 1500*15�� �߽��ϴ�.
					System.out.printf("���� : %d �� \n�ٹ� �ð� : %d �ð� \n�� �޿� : %d" ,abil,time,wage);
				}
				else
				{
					wage = 15000*40;
					System.out.printf("���� : %d �� \n�ٹ� �ð� : %d �ð� \n�� �޿� : %d" ,abil,time,wage);
				}
			
			}
			else if(abil == 5 || abil == 6)
			{
				if(time >= 40)
				{
					per = time - 40;
					wage = (20000*40) + (per*2000*15); // double�� �Ⱦ��� ���� 20000* 1.5 ��� 2000*15�� �߽��ϴ�.
					System.out.printf("���� : %d �� \n�ٹ� �ð� : %d �ð� \n�� �޿� : %d" ,abil,time,wage);
				}
				else
				{
					wage = 20000*40;
					System.out.printf("���� : %d �� \n�ٹ� �ð� : %d �ð� \n�� �޿� : %d" ,abil,time,wage);
				}
			
			}
			else
			{
				System.out.println("�߸� �Էµ� ���Դϴ�.");
			}
		
		}
}
