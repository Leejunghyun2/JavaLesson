package Exam01;

import java.util.Scanner;

public class IfExam05 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구입 시간을 입력하세요 : ");
			int time = Integer.parseInt(sc.nextLine());
		
		System.out.print("총 구입금액을 입력하세요 : ");
			int buy = Integer.parseInt(sc.nextLine());
			double per = 0;
		
			if(time < 12)
			{
				per = buy * 0.95;
				System.out.printf("구입시간 : %d 시 \n총 구입금액 : %d \n실제지불금액 : %d \n",time,buy,(int)per);
			}
			else if(time >= 12)
			{
				per = buy * 0.975;
				System.out.printf("구입시간 : %d 시 \n총 구입금액 : %d \n실제지불금액 : %d \n",time,buy,(int)per);
			}
	}
}
