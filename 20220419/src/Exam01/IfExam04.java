package Exam01;

import java.util.Scanner;

public class IfExam04 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է� �ϼ��� : ");
			int pos = Integer.parseInt(sc.nextLine());
		
		System.out.print("������ �Է��ϼ��� : ");
			int wage = Integer.parseInt(sc.nextLine());
			double per = 0;
		
			if(pos == 8 || pos == 7)
			{
				per = wage * 0.92;
				System.out.printf("���� : %d �� %n���� : %d %n�Ǽ��ɾ�(����8%%����) : %d %n",pos,wage,(int)per);
			}
			else if(pos == 6 || pos == 5)
			{
				per = wage * 0.88;
				System.out.printf("���� : %d �� %n���� : %d %n�Ǽ��ɾ�(����12%%����) : %d %n",pos,wage,(int)per);
			}
	}
}
