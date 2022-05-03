package Exam01;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int wage = 0;
			int per = 0;
		System.out.print("직급을 입력하세요 :");
			int abil = Integer.parseInt(sc.nextLine());
		System.out.print("근무시간을 입력하세요 :");
			int time = Integer.parseInt(sc.nextLine());
		
			if(abil == 7 || abil == 8)
			{
				if(time >= 40)
				{
					per = time - 40;
					wage = (15000*40) + (per*1500*15); // double형 안쓰기 위해 15000* 1.5 대신 1500*15로 했습니다.
					System.out.printf("직급 : %d 급 \n근무 시간 : %d 시간 \n주 급여 : %d" ,abil,time,wage);
				}
				else
				{
					wage = 15000*40;
					System.out.printf("직급 : %d 급 \n근무 시간 : %d 시간 \n주 급여 : %d" ,abil,time,wage);
				}
			
			}
			else if(abil == 5 || abil == 6)
			{
				if(time >= 40)
				{
					per = time - 40;
					wage = (20000*40) + (per*2000*15); // double형 안쓰기 위해 20000* 1.5 대신 2000*15로 했습니다.
					System.out.printf("직급 : %d 급 \n근무 시간 : %d 시간 \n주 급여 : %d" ,abil,time,wage);
				}
				else
				{
					wage = 20000*40;
					System.out.printf("직급 : %d 급 \n근무 시간 : %d 시간 \n주 급여 : %d" ,abil,time,wage);
				}
			
			}
			else
			{
				System.out.println("잘못 입력된 값입니다.");
			}
		
		}
}
