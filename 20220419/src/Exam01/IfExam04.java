package Exam01;

import java.util.Scanner;

public class IfExam04 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급을 입력 하세요 : ");
			int pos = Integer.parseInt(sc.nextLine());
		
		System.out.print("본봉을 입력하세요 : ");
			int wage = Integer.parseInt(sc.nextLine());
			double per = 0;
		
			if(pos == 8 || pos == 7)
			{
				per = wage * 0.92;
				System.out.printf("직급 : %d 급 %n본봉 : %d %n실수령액(세금8%%적용) : %d %n",pos,wage,(int)per);
			}
			else if(pos == 6 || pos == 5)
			{
				per = wage * 0.88;
				System.out.printf("직급 : %d 급 %n본봉 : %d %n실수령액(세금12%%적용) : %d %n",pos,wage,(int)per);
			}
	}
}
